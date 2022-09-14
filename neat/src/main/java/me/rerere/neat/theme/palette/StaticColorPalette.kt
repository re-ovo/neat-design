package me.rerere.neat.theme.palette

import androidx.compose.ui.graphics.Color

/**
 * 预定义的静态调色板
 *
 * 动态调色板算法并不完美，所以这里提供了一些预定义的静态调色板
 */
class StaticColorPalette(
    val lightColors: List<Color>,
    val darkColors: List<Color>
) : DayNightPalette {
    override val day: ColorPalette = object : ColorPalette {
        override fun getColor(index: Int): Color {
            return lightColors[index - 1]
        }
    }
    override val night: ColorPalette = object : ColorPalette {
        override fun getColor(index: Int): Color {
            return darkColors[index - 1]
        }
    }
}