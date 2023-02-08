package com.example.amphibians.ui.theme

import androidx.compose.material3.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.sp
import com.example.amphibians.R

// Set of Material typography styles to start with
private val comfortaaFontFamily = FontFamily(
    Font(R.font.comfortaa_bold),
    Font(R.font.comfortaa_light),
    Font(R.font.comfortaa_medium),
    Font(R.font.comfortaa_regular),
    Font(R.font.comfortaa_semibold)
)

val Typography = Typography(
    headlineLarge = TextStyle(
        fontFamily = comfortaaFontFamily,
        fontWeight = FontWeight(400),
        fontSize = 32.sp,
        textAlign = TextAlign.Justify
    ),
    titleLarge = TextStyle(
        fontFamily = comfortaaFontFamily,
        fontWeight = FontWeight(400),
        fontSize = 24.sp,
    ),
    bodyLarge = TextStyle(
        fontFamily = comfortaaFontFamily,
        fontWeight = FontWeight(400),
        fontSize = 16.sp,
        lineHeight = 24.sp
    )



)