package me.rerere.neat.theme

import androidx.compose.runtime.Stable
import androidx.compose.ui.graphics.Color
import me.rerere.neat.theme.palette.ColorPalette

@Stable
class ColorScheme(
    val isLight: Boolean,
    val primary: ColorPalette,
    val neutral: ColorPalette,
    val success: ColorPalette,
    val warning: ColorPalette,
    val error: ColorPalette,
    val link: ColorPalette,
    val scrim: Color
)

