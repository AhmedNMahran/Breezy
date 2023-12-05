package com.ahmednmahran.breezy.ui

import kotlinx.serialization.Serializable

@Serializable
data class WeatherUIModel(
    val unit: Unit,
    val temperature: String,
    val city: String,
    val hourlyForecast: List<HourlyForecast>,
    val dailyForecast: List<DailyForecast>,
)

@Serializable data class HourlyForecast(val temperature: String, val time: String)
@Serializable data class DailyForecast(val high: String, val low: String, val unit: Unit)

enum class Unit(val symbol: String) {
    CELSIUS("°C"), FAHRENHEIT("°F")
}
