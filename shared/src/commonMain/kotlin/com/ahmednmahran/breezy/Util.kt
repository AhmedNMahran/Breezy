package com.ahmednmahran.breezy

import com.ahmednmahran.breezy.model.WeatherResponse
import com.ahmednmahran.breezy.ui.DailyForecast
import com.ahmednmahran.breezy.ui.HourlyForecast
import com.ahmednmahran.breezy.ui.Unit
import com.ahmednmahran.breezy.ui.WeatherUIModel

fun WeatherResponse.asUIModel(): WeatherUIModel {
    return WeatherUIModel(
        unit =
        this.current_units.temperature_2m.toUnit(),
        temperature = this.current.temperature_2m.toString(),
        city = "Gaza", hourlyForecast = kotlin.run {
            hourly.temperature_2m.mapIndexed { index, it ->
                HourlyForecast(it.toString(), hourly.time[index],
                    hourly.weatherCodes?.get(index) ?: 0)
            }
        }, dailyForecast = kotlin.run {
            daily.temperature_2m_max.mapIndexed { index, d ->
                DailyForecast(
                    d.toString(), daily.temperature_2m_min[index].toString(),
                    daily_units.temperature_2m_max.toUnit(),
                    daily.weatherCodes?.get(index) ?: 0
                )
            }
        }
    ).also {
        println("WeatherUIModel $it")
    }

}


fun String.toUnit(): Unit =
    when {
        this == "°C" -> Unit.CELSIUS
        else -> Unit.FAHRENHEIT
    }