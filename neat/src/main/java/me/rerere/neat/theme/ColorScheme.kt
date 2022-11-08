package me.rerere.neat.theme

import androidx.compose.runtime.Stable
import me.rerere.neat.theme.palette.ColorPalette
import me.rerere.neat.theme.palette.ColorPalettes

@Stable
class ColorScheme(
    val primary: ColorPalette,
    val success: ColorPalette,
    val warning: ColorPalette,
    val error: ColorPalette,
    val info: ColorPalette,
    val neutral: ColorPalette
)

fun lightColorTheme(
    primary: ColorPalette = ColorPalettes.Blue.day,
    success: ColorPalette = ColorPalettes.Green.day,
    warning: ColorPalette = ColorPalettes.Yellow.day,
    error: ColorPalette = ColorPalettes.Red.day,
    info: ColorPalette = ColorPalettes.Blue.day,
    neutral: ColorPalette = ColorPalettes.Grey.day
) = ColorScheme(
    primary = primary,
    success = success,
    warning = warning,
    error = error,
    info = info,
    neutral = neutral
)

fun darkColorTheme(
    primary: ColorPalette = ColorPalettes.Blue.night,
    success: ColorPalette = ColorPalettes.Green.night,
    warning: ColorPalette = ColorPalettes.Yellow.night,
    error: ColorPalette = ColorPalettes.Red.night,
    info: ColorPalette = ColorPalettes.Blue.night,
    neutral: ColorPalette = ColorPalettes.Grey.night
) = ColorScheme(
    primary = primary,
    success = success,
    warning = warning,
    error = error,
    info = info,
    neutral = neutral
)