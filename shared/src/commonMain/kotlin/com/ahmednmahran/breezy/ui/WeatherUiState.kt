package com.ahmednmahran.breezy.ui

sealed class WeatherUiState {
    data object Loading : WeatherUiState()
    data class Success(val data: WeatherUIModel) : WeatherUiState()
    data class Error(val error: Throwable) : WeatherUiState()
}