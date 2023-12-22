package com.ahmednmahran.breezy.model

enum class WeatherCode(val code: Int, val description: String= "Unknown", val icon: String = "weather.xml", val isDay: Int = 1) {
    // Clear sky
    CLEAR_SKY_DAY(0, "Clear sky", "day.xml", 1),
    CLEAR_SKY_NIGHT(0, "Clear sky", "night.xml", 0),

    // Mainly clear, partly cloudy, and overcast
    MAINLY_CLEAR_DAY(1, "Mainly clear", "cloudy_day_1.xml", 1),
    PARTLY_CLOUDY_DAY(2, "Partly cloudy", "cloudy_day_2.xml", 1),
    OVERCAST_DAY(3, "Overcast", "cloudy_day_3.xml", 1),

    MAINLY_CLEAR_NIGHT(1, "Mainly clear", "cloudy_night_1.xml", 0),
    PARTLY_CLOUDY_NIGHT(2, "Partly cloudy", "cloudy_night_2.xml", 0),
    OVERCAST_NIGHT(3, "Overcast", "cloudy_night_3.xml", 0),

    // Fog and depositing rime fog
    FOG_AND_DEPOSITING_RIME_FOG_DAY(45, "Fog and depositing rime fog", "cloudy_day_3.xml", 1),
    FOG_AND_DEPOSITING_RIME_FOG_NIGHT(45, "Fog and depositing rime fog", "cloudy_night_3.xml", 0),

    // Drizzle: Light, moderate, and dense intensity
    DRIZZLE_LIGHT_DAY(51, "Drizzle: Light", "rainy_1.xml", 1),
    DRIZZLE_MODERATE_DAY(53, "Drizzle: Moderate", "rainy_2.xml", 1),
    DRIZZLE_DENSE_DAY(55, "Drizzle: Dense", "rainy_3.xml", 1),
    DRIZZLE_LIGHT_NIGHT(51, "Drizzle: Light", "rainy_4.xml", 0),
    DRIZZLE_MODERATE_NIGHT(53, "Drizzle: Moderate", "rainy_5.xml", 0),
    DRIZZLE_DENSE_NIGHT(55, "Drizzle: Dense", "rainy_6.xml", 0),

    // Freezing Drizzle: Light and dense intensity
    FREEZING_DRIZZLE_LIGHT_DAY(56, "Freezing Drizzle: Light", "snowy_1.xml", 1),
    FREEZING_DRIZZLE_DENSE_DAY(57, "Freezing Drizzle: Dense", "snowy_3.xml", 1),
    FREEZING_DRIZZLE_LIGHT_NIGHT(56, "Freezing Drizzle: Light", "snowy_4.xml", 0),
    FREEZING_DRIZZLE_DENSE_NIGHT(57, "Freezing Drizzle: Dense", "snowy_6.xml", 0),

    // Rain: Slight, moderate and heavy intensity
    RAIN_SLIGHT_DAY(61, "Rain: Slight", "rainy_1.xml", 1),
    RAIN_MODERATE_DAY(63, "Rain: Moderate", "rainy_2.xml", 1),
    RAIN_HEAVY_DAY(65, "Rain: Heavy", "rainy_3.xml", 1),
    RAIN_SLIGHT_NIGHT(61, "Rain: Slight", "rainy_4.xml", 0),
    RAIN_MODERATE_NIGHT(63, "Rain: Moderate", "rainy_5.xml", 0),
    RAIN_HEAVY_NIGHT(65, "Rain: Heavy", "rainy_6.xml", 0),

    // Freezing Rain: Light and heavy intensity
    FREEZING_RAIN_LIGHT_DAY(66, "Freezing Rain: Light", "snowy_1.xml", 1),
    FREEZING_RAIN_HEAVY_DAY(67, "Freezing Rain: Heavy", "snowy_3.xml", 1),
    FREEZING_RAIN_LIGHT_NIGHT(66, "Freezing Rain: Light", "snowy_4.xml", 0),
    FREEZING_RAIN_HEAVY_NIGHT(67, "Freezing Rain: Heavy", "snowy_6.xml", 0),

    // Snow fall: Slight, moderate, and heavy intensity

    SNOW_FALL_SLIGHT_DAY(71, "Snow fall: Slight", "snowy_1.xml", 1),
    SNOW_FALL_SLIGHT_NIGHT(71, "Snow fall: Slight", "snowy_1.xml", 0)
}
