package com.ahmednmahran.breezy.model

enum class WeatherCode(val code: Int, val description: String) {
    // Clear sky
    CLEAR_SKY(0, "Clear sky"),

    // Mainly clear, partly cloudy, and overcast
    MAINLY_CLEAR(1, "Mainly clear"),
    PARTLY_CLOUDY(2, "Partly cloudy"),
    OVERCAST(3, "Overcast"),

    // Fog and depositing rime fog
    FOG_AND_DEPOSITING_RIME_FOG(45, "Fog and depositing rime fog"),

    // Drizzle: Light, moderate, and dense intensity
    DRIZZLE_LIGHT(51, "Drizzle: Light"),
    DRIZZLE_MODERATE(53, "Drizzle: Moderate"),
    DRIZZLE_DENSE(55, "Drizzle: Dense"),

    // Freezing Drizzle: Light and dense intensity
    FREEZING_DRIZZLE_LIGHT(56, "Freezing Drizzle: Light"),
    FREEZING_DRIZZLE_DENSE(57, "Freezing Drizzle: Dense"),

    // Rain: Slight, moderate and heavy intensity
    RAIN_SLIGHT(61, "Rain: Slight"),
    RAIN_MODERATE(63, "Rain: Moderate"),
    RAIN_HEAVY(65, "Rain: Heavy"),

    // Freezing Rain: Light and heavy intensity
    FREEZING_RAIN_LIGHT(66, "Freezing Rain: Light"),
    FREEZING_RAIN_HEAVY(67, "Freezing Rain: Heavy"),

    // Snow fall: Slight, moderate, and heavy intensity

    SNOW_FALL_SLIGHT(71, "Snow fall: Slight"),
    SNOW_FALL_MODERATE(73, "Snow fall: Moderate"),
    SNOW_FALL_HEAVY(75, "Snow fall: Heavy"),

    // Snow grains
    SNOW_GRAINS(77, "Snow grains"),

    // Rain showers: Slight, moderate, and violent
    RAIN_SHOWERS_SLIGHT(80, "Rain showers: Slight"),
    RAIN_SHOWERS_MODERATE(81, "Rain showers: Moderate"),
    RAIN_SHOWERS_VIOLENT(82, "Rain showers: Violent"),

    // Snow showers slight and heavy
    SNOW_SHOWERS_SLIGHT(85, "Snow showers slight"),
    SNOW_SHOWERS_HEAVY(86, "Snow showers heavy"),

    // Thunderstorm: Slight or moderate
    THUNDERSTORM_SLIGHT_OR_MODERATE(95, "Thunderstorm: Slight or moderate"),

    // Thunderstorm with slight and heavy hail
    THUNDERSTORM_WITH_SLIGHT_HAIL(96, "Thunderstorm with slight hail"),
    THUNDERSTORM_WITH_HEAVY_HAIL(99, "Thunderstorm with heavy hail"),
}
