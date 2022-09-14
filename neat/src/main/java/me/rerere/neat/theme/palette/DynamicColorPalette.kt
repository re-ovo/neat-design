package me.rerere.neat.theme.palette

import androidx.compose.ui.graphics.Color
import me.rerere.neat.util.toHsv
import kotlin.math.ceil

/**
 * 根据seedColor自动计算出一套调色板
 */
class DynamicColorPalette(private val seed: Color) : DayNightPalette {
    override val day: ColorPalette
        get() = DayColorPalette(seed)

    override val night: ColorPalette
        get() = NightColorPalette(seed)
}

internal class DayColorPalette(private val seed: Color) : ColorPalette {
    private val colorCache by lazy {
        List(10) { i ->
            generateColor(i + 1)
        }
    }

    override fun getColor(index: Int): Color {
        require(index in 1..10)
        return colorCache[index - 1]
    }

    private fun generateColor(i: Int): Color {
        require(i in 1..10)

        var (h, s, v) = seed.toHsv()
        s *= 100f
        v *= 100f

        val hueStep = 2
        val maxSaturationStep = 100
        val minSaturationStep = 9
        val maxValue = 100
        val minValue = 30
        val isLight = i < 6
        val index = if (isLight) 6 - i else i - 6

        fun calculateHue(i: Int): Float {
            var hue = if (h in 60.0..240.0) {
                if (isLight) h - hueStep * i else h + hueStep * i
            } else {
                if (isLight) h + hueStep * i else h - hueStep * i
            }
            if (hue < 0) {
                hue += 360
            } else if (hue >= 360) {
                hue -= 360
            }
            return hue
        }

        fun calculateSaturation(i: Int): Float {
            return if (isLight) {
                if (s < minSaturationStep) s else s - ((s - minSaturationStep) / 5) * i
            } else {
                s + ((maxSaturationStep - s) / 4) * i
            }
        }

        fun calculateValue(i: Int): Float {
            return if (isLight) v + (maxValue - v) / 5 * i else if (v <= minValue) v else v - (v - minValue) / 4 * i
        }

        return if (i == 6) {
            seed
        } else {
            val hue = calculateHue(index)
            val saturation = calculateSaturation(index) / 100f
            val value = calculateValue(index) / 100f
            Color.hsv(hue, saturation, value)
        }
    }
}

internal class NightColorPalette(private val seed: Color) : ColorPalette {
    private val colorCache by lazy {
        List(10) { i ->
            generateColor(i + 1)
        }
    }
    private val dayPalette = DayColorPalette(seed)

    override fun getColor(index: Int): Color {
        require(index in 1..10)
        return colorCache[index - 1]
    }

    private fun generateColor(i: Int): Color {
        require(i in 1..10)
        val lightColor = dayPalette.getColor(10 - i + 1)
        val originBaseHue = seed.toHsv().h
        val originBaseSaturation = seed.toHsv().s * 100f
        val baseColor = Color.hsv(
            hue = seed.toHsv().h,
            saturation = when {
                originBaseHue >= 0 && originBaseHue < 50 -> originBaseSaturation - 15
                originBaseHue >= 50 && originBaseHue < 191 -> originBaseSaturation - 20
                originBaseHue in 191.0..360.0 -> originBaseSaturation - 15
                else -> error("hue is not in 0..360")
            } / 100f,
            value = seed.toHsv().v
        )
        val baseSaturation = baseColor.toHsv().s * 100f
        val step = ceil((baseSaturation - 9) / 4)
        val step1to5 = ceil((100 - baseSaturation) / 5)

        fun getNewSaturation(index: Int): Float {
            if (index < 6) {
                return baseSaturation + (6 - index) * step1to5
            }
            if (index == 6) {
                if (originBaseHue >= 0 && originBaseHue < 50) {
                    return originBaseSaturation - 15
                }
                if (originBaseHue >= 50 && originBaseHue < 191) {
                    return originBaseSaturation - 20
                }
                if (originBaseHue in 191.0..360.0) {
                    return originBaseSaturation - 15
                }
            }
            return baseSaturation - step * (index - 6)
        }
        return Color.hsv(
            hue = lightColor.toHsv().h,
            value = lightColor.toHsv().v,
            saturation = (getNewSaturation(i) / 100f).coerceIn(0f, 1f)
        )
    }
}