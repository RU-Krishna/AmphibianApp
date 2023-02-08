package com.example.amphibians.ui.theme

import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.ui.graphics.Color


val lightColorPalette = lightColorScheme(
    primary = Color(0xFF00BFD8),
    onPrimary = Color(0xFF000000),
    background = Color(0xFFCCF1F5),
    onBackground = Color(0xFFB00020),
    surface = Color(0xFFA9EBF3),
    onSurface = Color(0xFF000000),
    outline = Color(0xFF0291A3),
    errorContainer = Color(0xFFB00020),
    onErrorContainer = Color(0xFFFFFFFF)
)

val darkColorPalette = darkColorScheme(
    primary = Color(0xFFB4BEF7),
    onPrimary = Color(0xFFFFFFFF),
    background = Color(0xFFC8EEFF),
    onBackground = Color(0xFFB00020),
    surface = Color(0xFFA7D8FF),
    onSurface = Color(0xFFFFFFFF),
    outline = Color(0xFFAE80FF),
    errorContainer = Color(0xFFB00020),
    onErrorContainer = Color(0xFFFFFFFF)
)