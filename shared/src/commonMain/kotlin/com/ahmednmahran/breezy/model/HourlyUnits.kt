package com.ahmednmahran.breezy.model

import kotlinx.serialization.Serializable

@Serializable
data class HourlyUnits(
    val time: String,
    val temperature_2m: String,
    val weather_code: String
)