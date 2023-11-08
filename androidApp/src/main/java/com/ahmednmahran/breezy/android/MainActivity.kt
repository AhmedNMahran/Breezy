package com.ahmednmahran.breezy.android

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.ahmednmahran.breezy.Unit
import com.ahmednmahran.breezy.WeatherUIModel

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyApplicationTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    WeatherView(WeatherUIModel(Unit.CELSIUS, "23", "Cairo"))
                }
            }
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
                    fontSize = 64.sp))
            Text(text = model.unit.symbol)
        }
    }
}


@Preview
@Composable
fun DefaultPreview() {
    MyApplicationTheme {
        WeatherView(WeatherUIModel(Unit.CELSIUS, "23", "Cairo"))
    }
}
