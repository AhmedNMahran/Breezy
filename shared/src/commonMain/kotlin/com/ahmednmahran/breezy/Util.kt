package com.ahmednmahran.breezy

import com.ahmednmahran.breezy.model.WeatherResponse
import com.ahmednmahran.breezy.ui.DailyForecast
import com.ahmednmahran.breezy.ui.HourlyForecast
import com.ahmednmahran.breezy.ui.Unit
import com.ahmednmahran.breezy.ui.WeatherUIModel
import kotlin.math.roundToInt

fun WeatherResponse.asUIModel(): WeatherUIModel {
    return WeatherUIModel(
        unit =
        this.current_units.temperature_2m.toUnit(),
        temperature = this.current.temperature_2m.roundToInt().toString(),
        city = "Gaza", hourlyForecast = kotlin.run {
            hourly.temperature_2m.mapIndexed { index, it ->
                HourlyForecast(it.roundToInt().toString(), hourly.time[index],
                    hourly.weatherCodes?.get(index) ?: 0)
            }
        }, dailyForecast = kotlin.run {
            daily.temperature_2m_max.mapIndexed { index, d ->
                DailyForecast(
                    d.roundToInt().toString(),
                    daily.temperature_2m_min[index].roundToInt().toString(),
                    daily_units.temperature_2m_max.toUnit(),
                    daily.weatherCodes?.get(index) ?: 0
                )
            }
        },
        weatherCode = this.current.weatherCode
    ).also {
        println("WeatherUIModel $it")
    }

}


fun String.toUnit(): Unit =
    when {
        this == "°C" -> Unit.CELSIUS
        else -> Unit.FAHRENHEIT
    }