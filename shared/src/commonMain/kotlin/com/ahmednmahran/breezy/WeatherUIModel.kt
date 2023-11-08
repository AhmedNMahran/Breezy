package com.ahmednmahran.breezy

data class WeatherUIModel(
    val unit: Unit,
    val temperature: String,
    val city: String,
)

enum class Unit(val symbol: String) {
    CELSIUS("°C"), FAHRENHEIT("°F")
}
