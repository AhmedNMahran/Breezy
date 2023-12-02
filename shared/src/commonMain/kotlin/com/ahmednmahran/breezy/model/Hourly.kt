package com.ahmednmahran.breezy.model

import kotlinx.serialization.Serializable

@Serializable
data class Hourly(
    val time: List<String>,
    val temperature_2m: List<Double>
)