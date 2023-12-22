package com.ahmednmahran.breezy.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.isSystemInDarkTheme
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
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clipToBounds
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.ahmednmahran.breezy.appBackgroundColors
import com.ahmednmahran.breezy.titleStyle
import com.ahmednmahran.breezy.ui.HourlyForecast
import com.ahmednmahran.breezy.ui.WeatherUIModel
import org.jetbrains.compose.resources.ExperimentalResourceApi
import org.jetbrains.compose.resources.painterResource

@OptIn(ExperimentalResourceApi::class)
@Composable
fun WeatherView(model: WeatherUIModel) {
    Box {
        Column(
            modifier = Modifier
                .padding(16.dp)
                 // padding around the column
                .fillMaxSize(), // fill the available space
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            val weatherCode = remember { model.weatherCode }
            Image(
                modifier = Modifier.size(128.dp),
                painter = painterResource(weatherCode.icon),
                contentDescription = weatherCode.description // description
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

@OptIn(ExperimentalResourceApi::class)
@Composable
fun HourlyForecastView(model: HourlyForecast) {
    ElevatedCard(Modifier.padding(8.dp).clipToBounds()) {
        Column(
            Modifier.background(
                brush = Brush.linearGradient(
                    colors = appBackgroundColors(isSystemInDarkTheme()),
                ), alpha = (0.5f)
            ).padding(16.dp),
            verticalArrangement = Arrangement.SpaceEvenly,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            val weatherCode = remember { model.weatherCode }
            Text(model.time.substringAfter('T'))
            Image(
                painter = painterResource(weatherCode.icon),
                contentDescription = weatherCode.description // description
            )
            Text(model.temperature)
        }
    }

}