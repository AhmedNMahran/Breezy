package com.ahmednmahran.breezy

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import com.ahmednmahran.breezy.ui.WeatherUiState
import com.ahmednmahran.breezy.ui.WeatherViewModel
import com.ahmednmahran.breezy.ui.components.ErrorView
import com.ahmednmahran.breezy.ui.components.LoadingView
import com.ahmednmahran.breezy.ui.components.WeatherView

val weatherViewModel = WeatherViewModel()
@Composable
fun App() {

    BreezyTheme {
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colorScheme.background
        ) {
            val uiState: WeatherUiState by weatherViewModel.uiState.collectAsState()
            LaunchedEffect(weatherViewModel) {
                weatherViewModel.getWeather()
            }
            when (uiState) {
                is WeatherUiState.Loading -> {
                    LoadingView()
                }

                is WeatherUiState.Success -> {
                    WeatherView((uiState as WeatherUiState.Success).data)
                }

                is WeatherUiState.Error -> {
                    ErrorView("Error")
                }
            }
        }
    }
}