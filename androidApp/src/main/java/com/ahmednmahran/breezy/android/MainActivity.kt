package com.ahmednmahran.breezy.android

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.ahmednmahran.breezy.App
import com.ahmednmahran.breezy.ui.components.ErrorView
import com.ahmednmahran.breezy.ui.components.LoadingView

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            App()
        }
    }
}


@Preview
@Composable
fun DefaultPreview() {
    App()
}

@Preview
@Composable
fun ErrorPreview() {
    ErrorView("Error")
}

@Preview
@Composable
fun LoadingPreview() {
    LoadingView()
}
