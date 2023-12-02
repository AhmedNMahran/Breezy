package com.ahmednmahran.breezy.api

import com.ahmednmahran.breezy.DailyForecast
import com.ahmednmahran.breezy.HourlyForecast
import com.ahmednmahran.breezy.Unit
import com.ahmednmahran.breezy.WeatherUIModel
import com.ahmednmahran.breezy.model.WeatherResponse
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.request.get
import io.ktor.client.statement.bodyAsText
import io.ktor.serialization.kotlinx.json.json
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.IO
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch


private const val BASE_URL = "https://api.open-meteo.com/v1/forecast"

class WeatherViewModel {
    private val _uiState = MutableStateFlow(
        WeatherUIModel(
            Unit.CELSIUS, "19", "Cairo",
            emptyList(), emptyList()
        )
    )
    val uiState = _uiState.asStateFlow()
    private val client by lazy {
        HttpClient() {
            install(ContentNegotiation) {
                json()
            }
        }
    }


    fun getWeather(
        latitude: Double = 34.4667,
        longitude: Double = 31.5016,
        forecastDays: Int = 1
    ) {
        CoroutineScope(Dispatchers.IO).launch {
            val response = getWeatherResponse(
                "$BASE_URL?latitude=$latitude&longitude=$longitude&hourly=temperature_2m&daily=temperature_2m_max,temperature_2m_min&timezone=Africa%2FCairo&forecast_days=$forecastDays"
            )
            _uiState.update {
                with(response.asUIModel()) {
                    it.copy(
                        unit = unit,
                        temperature = temperature,
                        city = city,
                        hourlyForecast = hourlyForecast
                    )
                }
            }
        }
    }

    private suspend fun getWeatherResponse(url: String): WeatherResponse {
        return client.get(url).let {
            println("url: $url")
            it.bodyAsText().also { json -> println("BreezyViewModel: $json") }
            it.body()
        }
    }

    fun clear() {
        client.close()
    }
}

fun WeatherResponse.asUIModel(): WeatherUIModel {
    return WeatherUIModel(
        unit =
        this.daily_units.temperature_2m_max.toUnit(),
        temperature = this.daily.toString(),
        city = "Gaza", hourlyForecast = kotlin.run {
            hourly.temperature_2m.mapIndexed { index, it ->
                HourlyForecast(it.toString(), hourly.time[index])
            }
        }, dailyForecast = kotlin.run {
            daily.temperature_2m_max.mapIndexed { index, d ->
                DailyForecast(
                    d.toString(), daily.temperature_2m_min[index].toString(),
                    daily_units.temperature_2m_max.toUnit()
                )
            }
        }
    ).also {
        println("WeatherUIModel $it")
    }

}

fun String.toUnit(): Unit =
    when{
        this == "°C" -> Unit.CELSIUS
        else -> Unit.FAHRENHEIT
    }

