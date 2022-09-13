package me.rerere.neat.util

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.luminance
import kotlin.math.roundToInt

internal infix fun Color.contrast(other: Color) = (this.luminance() + 0.05) / (other.luminance() + 0.05)

internal val Color.hexValue get() = "#${this.value.toString(16).take(8).uppercase()}"

internal fun Color.toHsv(): HsvColor {
    val result = FloatArray(3)
    android.graphics.Color.RGBToHSV(
        (this.red * 255).roundToInt(),
        (this.green * 255).roundToInt(),
        (this.blue * 255).roundToInt(),
        result
    )
    return HsvColor(
        h = result[0],
        s = result[1],
        v = result[2]
    )
}

internal data class HsvColor(
    val h: Float,
    val s: Float,
    val v: Float
)
