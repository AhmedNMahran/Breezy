package com.ahmednmahran.breezy.model

import kotlinx.serialization.Serializable

@Serializable
data class DailyUnits(
    val time: String,
    val temperature_2m_max: String,
    val temperature_2m_min: String
)