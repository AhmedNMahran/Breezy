package com.ahmednmahran.breezy

import com.ahmednmahran.breezy.model.WeatherCode
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
        city = "Gaza",
        hourlyForecast = kotlin.run {
            hourly.temperature_2m.mapIndexed { index, it ->
                HourlyForecast(it.roundToInt().toString(), hourly.time[index],
                    weatherCode = getWeatherCode(
                        hourly.weatherCodes?.get(index) ?: 0,
                        if (isDay(index)) 1 else 0
                    )
                )
            }
        },
        dailyForecast = kotlin.run {
            daily.temperature_2m_max.mapIndexed { index, d ->
                DailyForecast(
                    d.roundToInt().toString(),
                    daily.temperature_2m_min[index].roundToInt().toString(),
                    daily_units.temperature_2m_max.toUnit(),
                    weatherCode = getWeatherCode(
                        daily.weatherCodes?.get(index) ?: 0,
                        1
                    )
                )
            }
        },
        weatherCode = getWeatherCode(this.current.weatherCode,this.current.is_day)
    ).also {
        println("WeatherUIModel $it")
    }

}

/**
 * use the remainder operator to divide the hour index by 12
 * and check if the remainder is less than 6.
 * If the remainder is less than 6, then it is day. Otherwise, it is night
 */
fun isDay(hourIndex: Int): Boolean {
    return hourIndex % 12 < 6
}


private fun getWeatherCode(code: Int, isDay: Int) = WeatherCode.entries
    .find {
        it.code == code && it.isDay == isDay
    } ?: WeatherCode.CLEAR_SKY_DAY


fun String.toUnit(): Unit =
    when {
        this == "°C" -> Unit.CELSIUS
        else -> Unit.FAHRENHEIT
    }