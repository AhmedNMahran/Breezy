package com.ahmednmahran.breezy.model

import kotlinx.serialization.Serializable

@Serializable
data class Current(
    val time: String,
    val interval: Double,
    val temperature_2m: Double,
    val is_day: Int,
)

