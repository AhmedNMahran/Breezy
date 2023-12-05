package com.ahmednmahran.breezy.ui.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.ahmednmahran.breezy.ui.WeatherUIModel

@Composable
fun WeatherView(model: WeatherUIModel) {
    Column(
        modifier = Modifier
            .padding(16.dp) // padding around the column
            .fillMaxSize(), // fill the available space
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