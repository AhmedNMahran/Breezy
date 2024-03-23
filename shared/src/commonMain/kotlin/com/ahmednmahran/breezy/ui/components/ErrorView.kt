package com.ahmednmahran.breezy.ui.components

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp

@Composable
fun ErrorView(errorMessage: String) {
    Box(
        modifier = Modifier
            .padding(16.dp) // padding around the column
            .fillMaxSize(), // fill the available space
        contentAlignment = Alignment.Center
    ) {
        Text(text = errorMessage, style = TextStyle(color = Color.Red))
    }
}