package com.ahmednmahran.breezy.ui

import com.ahmednmahran.breezy.model.WeatherCode
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class WeatherUIModel(
    val unit: Unit,
    val temperature: String,
    val city: String,
    val hourlyForecast: List<HourlyForecast>,
    val dailyForecast: List<DailyForecast>,
    val weatherCode: WeatherCode = WeatherCode.CLEAR_SKY_DAY
)

@Serializable
data class HourlyForecast(
    val temperature: String, val time: String,
    @SerialName("weather_code") val weatherCode: WeatherCode = WeatherCode.CLEAR_SKY_DAY
)

@Serializable
data class DailyForecast(
    val high: String,
    val low: String,
    val unit: Unit,
    @SerialName("weather_code") val weatherCode: WeatherCode = WeatherCode.CLEAR_SKY_DAY
)

enum class Unit(val symbol: String) {
    CELSIUS("°C"), FAHRENHEIT("°F")
}
