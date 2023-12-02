package com.ahmednmahran.breezy

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.ahmednmahran.breezy.api.WeatherViewModel

val weatherViewModel = WeatherViewModel()
@Composable
fun App() {

    BreezyTheme {
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colorScheme.background
        ) {

            var text by remember { mutableStateOf("Loading") }
            val uiState: WeatherUIModel by weatherViewModel.uiState.collectAsState()
            LaunchedEffect(weatherViewModel) {
                weatherViewModel.getWeather()
            }
            WeatherView(uiState)
            println("state: $text")
        }
    }
}

@Composable
fun WeatherView(model: WeatherUIModel) {
    Column(
        modifier = Modifier
            .padding(16.dp) // padding around the column
            .fillMaxWidth(), // fill the available space
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(text = model.city,
            style = MaterialTheme.typography.headlineLarge
        )
        Spacer(modifier = Modifier.height(32.dp))
        Row {
            Text(text = model.temperature,
                style = TextStyle(fontWeight = FontWeight.Bold,
                    fontSize = 64.sp)
            )
            Text(text = model.unit.symbol)
        }
    }
}