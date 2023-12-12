package com.ahmednmahran.breezy.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clipToBounds
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.ahmednmahran.breezy.model.WeatherCode.CLEAR_SKY
import com.ahmednmahran.breezy.model.WeatherCode.FOG_AND_DEPOSITING_RIME_FOG
import com.ahmednmahran.breezy.model.WeatherCode.FREEZING_RAIN_HEAVY
import com.ahmednmahran.breezy.model.WeatherCode.FREEZING_RAIN_LIGHT
import com.ahmednmahran.breezy.model.WeatherCode.MAINLY_CLEAR
import com.ahmednmahran.breezy.model.WeatherCode.OVERCAST
import com.ahmednmahran.breezy.model.WeatherCode.PARTLY_CLOUDY
import com.ahmednmahran.breezy.model.WeatherCode.RAIN_HEAVY
import com.ahmednmahran.breezy.model.WeatherCode.RAIN_MODERATE
import com.ahmednmahran.breezy.model.WeatherCode.RAIN_SHOWERS_MODERATE
import com.ahmednmahran.breezy.model.WeatherCode.RAIN_SHOWERS_SLIGHT
import com.ahmednmahran.breezy.model.WeatherCode.RAIN_SHOWERS_VIOLENT
import com.ahmednmahran.breezy.model.WeatherCode.RAIN_SLIGHT
import com.ahmednmahran.breezy.model.WeatherCode.SNOW_FALL_HEAVY
import com.ahmednmahran.breezy.model.WeatherCode.SNOW_FALL_MODERATE
import com.ahmednmahran.breezy.model.WeatherCode.SNOW_FALL_SLIGHT
import com.ahmednmahran.breezy.model.WeatherCode.SNOW_GRAINS
import com.ahmednmahran.breezy.model.WeatherCode.SNOW_SHOWERS_HEAVY
import com.ahmednmahran.breezy.model.WeatherCode.SNOW_SHOWERS_SLIGHT
import com.ahmednmahran.breezy.titleStyle
import com.ahmednmahran.breezy.ui.HourlyForecast
import com.ahmednmahran.breezy.ui.WeatherUIModel
import compose.icons.WeatherIcons
import compose.icons.weathericons.DaySunny
import compose.icons.weathericons.DaySunnyOvercast
import compose.icons.weathericons.Fog
import compose.icons.weathericons.NightPartlyCloudy
import compose.icons.weathericons.Rain
import compose.icons.weathericons.Snow
import compose.icons.weathericons.Thunderstorm
import org.jetbrains.compose.resources.ExperimentalResourceApi

@OptIn(ExperimentalResourceApi::class)
@Composable
fun WeatherView(model: WeatherUIModel) {
    Box {
        Column(
            modifier = Modifier
                .background(
                    brush = Brush.linearGradient(
                        colors = listOf(
                            MaterialTheme.colorScheme.background,
                            Color.Blue,
                        ),
                    ), alpha = (0.5f)
                ).padding(16.dp)
                 // padding around the column
                .fillMaxSize(), // fill the available space
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            val icon = remember { WeatherIcons.iconOf(model.weatherCode) }
            Icon(
                modifier = Modifier.size(48.dp),
                imageVector = icon,
                contentDescription = "weather icon"
            )
            Spacer(modifier = Modifier.height(32.dp))
            Text(
                text = model.city,
                style = titleStyle
            )
            Spacer(modifier = Modifier.height(32.dp))
            Row {
                Text(
                    text = model.temperature,
                    style = TextStyle(
                        fontWeight = FontWeight.Bold,
                        fontSize = 64.sp
                    )
                )
                Text(text = model.unit.symbol, style = MaterialTheme.typography.headlineLarge)
            }
            Spacer(modifier = Modifier.height(32.dp))
            LazyRow(Modifier.align(Alignment.Start)) {
                items(model.hourlyForecast) {
                    HourlyForecastView(it)
                }
            }

        }
    }
}

@Composable
fun HourlyForecastView(model: HourlyForecast) {
    ElevatedCard(Modifier.padding(8.dp).clipToBounds()) {
        Column(
            Modifier.background(
                brush = Brush.linearGradient(
                    colors = listOf(
                        MaterialTheme.colorScheme.background,
                        Color.Blue,
                    ),
                ), alpha = (0.5f)
            ).padding(16.dp),
            verticalArrangement = Arrangement.SpaceEvenly,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            val icon = remember { WeatherIcons.iconOf(model.weatherCode) }
            Text(model.time.substringAfter('T'))
            Icon(imageVector = icon, "weather icon")
            Text(model.temperature)
        }
    }

}

fun WeatherIcons.iconOf(code: Int): ImageVector {
    return when (code) {
        CLEAR_SKY.code, MAINLY_CLEAR.code -> DaySunny
        OVERCAST.code -> DaySunnyOvercast
        PARTLY_CLOUDY.code -> NightPartlyCloudy
        SNOW_FALL_HEAVY.code, SNOW_FALL_SLIGHT.code,
        SNOW_FALL_MODERATE.code, SNOW_GRAINS.code,
        SNOW_SHOWERS_SLIGHT.code, SNOW_SHOWERS_HEAVY.code -> Snow

        FOG_AND_DEPOSITING_RIME_FOG.code -> Fog
        RAIN_SLIGHT.code,
        RAIN_MODERATE.code,
        RAIN_HEAVY.code,
        FREEZING_RAIN_LIGHT.code,
        FREEZING_RAIN_HEAVY.code,
        RAIN_SHOWERS_SLIGHT.code,
        RAIN_SHOWERS_MODERATE.code,
        RAIN_SHOWERS_VIOLENT.code -> Rain

        else -> Thunderstorm
    }
}