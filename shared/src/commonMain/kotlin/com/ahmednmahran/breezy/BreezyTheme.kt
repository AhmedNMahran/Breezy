package com.ahmednmahran.breezy

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Shapes
import androidx.compose.material3.Typography
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun BreezyTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> kotlin.Unit
) {
    val colors = if (darkTheme) {
        darkColorScheme(
            primary = Color(0xFFBB86FC),
            secondary = Color(0xFF03DAC5),
            tertiary = Color(0xFF3700B3)
        )
    } else {
        lightColorScheme(
            primary = Color(17345),
            secondary = Color(0xFF03DAC5),
            tertiary = Color(0xFF3700B3)
        )
    }
    val typography = Typography(
        bodyMedium = TextStyle(
            fontFamily = FontFamily.Default,
            fontWeight = FontWeight.Normal,
            fontSize = 16.sp
        )
    )
    val shapes = Shapes(
        small = RoundedCornerShape(4.dp),
        medium = RoundedCornerShape(4.dp),
        large = RoundedCornerShape(0.dp)
    )

    MaterialTheme(
        colorScheme = colors,
        typography = typography,
        shapes = shapes,
        content = content
    )
}

val titleStyle = TextStyle(
    fontWeight = FontWeight.Bold,
    fontSize = 54.sp,
)

fun appBackgroundColors(darkTheme: Boolean = false): List<Color> {
    return if (darkTheme) {
        listOf(
            Color(0xFF5C6BC0),
            Color(0xFF3F51B5),
            Color(0xFF3949AB),
            Color(0xFF303F9F),
            Color(0xFF283593),
            Color(0xFF1A237E)
        )
    } else {
        listOf(
            Color(0xFF29B6F6),
            Color(0xFF03A9F4),
            Color(0xFF039BE5),
            Color(0xFF0288D1),
            Color(0xFF0277BD),
            Color(0xFF01579B)
        )
    }
}