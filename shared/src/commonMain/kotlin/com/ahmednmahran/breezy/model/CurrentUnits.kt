package com.ahmednmahran.breezy.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class CurrentUnits(
    val time: String,
    val interval: String,
    val temperature_2m: String,
    val is_day: String,
    @SerialName("weather_code")
    val weatherCode: String
)