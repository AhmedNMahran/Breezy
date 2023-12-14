package com.ahmednmahran.breezy

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.layout.ContentScale
import com.ahmednmahran.breezy.ui.WeatherUiState
import com.ahmednmahran.breezy.ui.WeatherViewModel
import com.ahmednmahran.breezy.ui.components.ErrorView
import com.ahmednmahran.breezy.ui.components.LoadingView
import com.ahmednmahran.breezy.ui.components.WeatherView
import org.jetbrains.compose.resources.ExperimentalResourceApi
import org.jetbrains.compose.resources.painterResource

val weatherViewModel = WeatherViewModel()

@OptIn(ExperimentalResourceApi::class)
@Composable
fun App() {

    BreezyTheme {
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colorScheme.background
        ) {

            Image(
                modifier = Modifier.fillMaxSize(),
                painter = painterResource("background_clouds_shutterstock.png"),
                contentScale = ContentScale.FillBounds,
                contentDescription = null
            )
            val uiState: WeatherUiState by weatherViewModel.uiState.collectAsState()
            LaunchedEffect(weatherViewModel) {
                weatherViewModel.getWeather()
            }
            Box(
                Modifier.background(
                    brush = Brush.linearGradient(
                        colors = appBackgroundColors(isSystemInDarkTheme()),
                    ), alpha = (0.7f)
                )
            ) {

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
}