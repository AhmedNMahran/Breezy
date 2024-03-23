package com.ahmednmahran.breezy.ui

import com.ahmednmahran.breezy.asUIModel
import com.ahmednmahran.breezy.model.WeatherResponse
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.plugins.HttpTimeout
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.request.get
import io.ktor.client.statement.bodyAsText
import io.ktor.serialization.kotlinx.json.json
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.IO
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.withContext


private const val BASE_URL = "https://api.open-meteo.com/v1/forecast"
private const val WEATHER_CODE = "weather_code"
private const val HOURLY = "hourly"
private const val DAILY = "daily"
private const val CURRENT = "current"

private const val LAT = "latitude"

private const val LNG = "longitude"

private const val TEMP = "temperature_2m"

private const val TEMP_MAX = "temperature_2m_max"
private const val TEMP_MIN = "temperature_2m_min"

private const val DAYS = "forecast_days"

private const val ZONE = "timezone"

private const val IS_DAY = "is_day"

private const val ZONE_VALUE = "Africa%2FCairo"
private const val CURRENT_CALL = "$CURRENT=$TEMP,$IS_DAY,$WEATHER_CODE"
private const val HOURLY_CALL = "$HOURLY=$TEMP,$WEATHER_CODE"
private const val DAILY_CALL = "$DAILY=$TEMP_MAX,$TEMP_MIN,$WEATHER_CODE"


class WeatherViewModel {
    private val _uiState: MutableStateFlow<WeatherUiState> = MutableStateFlow(
        WeatherUiState.Loading
    )
    val uiState = _uiState.asStateFlow()
    //
    private val client by lazy {
        HttpClient {
            // this is used to handle serialization from-to json
            install(ContentNegotiation) {
                json()
            }
            // this is used to handle timeouts
            install(HttpTimeout) {
                requestTimeoutMillis = 3000
            }
        }
    }


    suspend fun getWeather(
        latitude: Double = 31.5016,
        longitude: Double = 34.4667,
        forecastDays: Int = 1
    ) {
        _uiState.update { WeatherUiState.Loading }

        try {
            val weatherUIModel: WeatherUIModel
            withContext(Dispatchers.IO) {
                // get weather as ui model
                weatherUIModel = getWeatherResponse(
                    buildUrl(latitude, longitude, forecastDays)
                ).asUIModel()
            }
            // update with success state
            _uiState.update {
                WeatherUiState.Success(weatherUIModel)
            }

        } catch (error: Throwable) {
            withContext(Dispatchers.Main) {
                // update with error state
                _uiState.update {
                    println("WeatherError: "+error.message)
                    WeatherUiState.Error(error)
                }
            }
        }
    }

    /**
     * get weather response from api
     */
    private suspend fun getWeatherResponse(url: String): WeatherResponse {
        return client.get(url).let {
            println("url: $url")
            it.bodyAsText().also { json -> println("BreezyViewModel: $json") }
            it.body()
        }
    }

    /**
     * build url using latitude, longitude and forecast days
     */
    private fun buildUrl(
        latitude: Double,
        longitude: Double,
        forecastDays: Int
    ) =
        "$BASE_URL?$LAT=$latitude&$LNG=$longitude&$CURRENT_CALL&$HOURLY_CALL&$DAILY_CALL&$ZONE=$ZONE_VALUE&$DAYS=$forecastDays"

    /**
     * replicate the lifecycle of the view model
     */
    fun clear() {
        client.close()
    }
}

