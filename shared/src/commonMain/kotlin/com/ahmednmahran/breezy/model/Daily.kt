package com.ahmednmahran.breezy.model

import kotlinx.serialization.Serializable

@Serializable
data class Daily(
    val time: List<String>,
    val temperature_2m_max: List<Double>,
    val temperature_2m_min: List<Double>
)