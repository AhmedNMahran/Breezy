package com.ahmednmahran.breezy.model

import kotlinx.serialization.Serializable

@Serializable
data class WeatherResponse(
    val latitude: Double,
    val longitude: Double,
    val generationtime_ms: Double,
    val utc_offset_seconds: Int,
    val timezone: String,
    val timezone_abbreviation: String,
    val elevation: Double,
    val hourly_units: HourlyUnits,
    val hourly: Hourly,
    val daily_units: DailyUnits,
    val current: Current,
    val current_units: CurrentUnits,
    val daily: Daily,
)