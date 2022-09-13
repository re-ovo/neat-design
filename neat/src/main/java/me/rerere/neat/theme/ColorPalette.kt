package me.rerere.neat.theme

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.BasicText
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.util.fastForEachIndexed
import me.rerere.neat.util.contrast
import me.rerere.neat.util.hexValue
import me.rerere.neat.util.toHsv

private const val LIGHT_COLOR_COUNT = 5
private const val DARK_COLOR_COUNT = 4
private const val hueStep = 2;
private const val saturationStep = 0.16;
private const val saturationStep2 = 0.05;
private const val brightnessStep1 = 0.05;
private const val brightnessStep2 = 0.15;

@Composable
fun ColorPalettePreview(color: Color) {
    val platte = remember(color) {
        ColorPalette(color)
    }
    Column(
        modifier = Modifier.padding(8.dp)
    ) {
        Box(
            modifier = Modifier
                .width(100.dp)
                .height(40.dp)
                .background(color),
            contentAlignment = Alignment.Center
        ) {
            BasicText("[${color.hexValue}]")
        }
        Spacer(modifier = Modifier.height(10.dp))
        platte.paletteColorList.fastForEachIndexed { index, color ->
            Box(
                modifier = Modifier
                    .width(100.dp)
                    .height(40.dp)
                    .background(color),
                contentAlignment = Alignment.Center
            ){
                BasicText(
                    text = "[${index + 1}] ${color.hexValue}",
                )
            }
        }
    }
}

class ColorPalette(
    private val seedColor: Color
) {
    internal val paletteColorList: List<Color> = List(10) { index ->
        calculateColor(seedColor, index + 1)
    }

    fun getColor(type: Int): Color {
        require(type in 1..10) {
            "type must in 1~10"
        }
        return paletteColorList[type - 1]
    }
}

// https://github.com/ant-design/ant-design/blob/master/components/style/color/colorPalette.less
private fun calculateColor(color: Color, index: Int): Color {
    require(index in 1..10) {
        "index must in 1~10"
    }

    val isLight = index <= 6
    val hsv = color.toHsv()
    val i = if (isLight) LIGHT_COLOR_COUNT + 1 - index else index - LIGHT_COLOR_COUNT - 1

    // 计算H
    fun hue(): Float {
        var hue = if (hsv.h in 60.0..240.0) {
            if (isLight) hsv.h - hueStep * i else hsv.h + hueStep * i
        } else {
            if (isLight) hsv.h + hueStep * i else hsv.h - hueStep * i
        }
        if (hue < 0) {
            hue += 360
        } else if (hue >= 360) {
            hue -= 360
        }
        return hue
    }

    // 计算S
    fun saturation(): Float {
        if (hsv.h == 0f && hsv.s == 0f) {
            return hsv.s
        }
        var saturation = if (isLight) {
            hsv.s - saturationStep * i
        } else if (i == DARK_COLOR_COUNT) {
            hsv.s + saturationStep
        } else {
            hsv.s + saturationStep2 * i
        }
        if (saturation > 1) {
            saturation = 1.0
        }
        if (isLight && i == LIGHT_COLOR_COUNT && saturation > 0.1) {
            saturation = 0.1
        }
        return saturation.coerceAtLeast(0.06).toFloat()
    }

    // 计算V
    fun value(): Float {
        return if (isLight) {
            hsv.v + brightnessStep1 * i
        } else {
            hsv.v - brightnessStep2 * i
        }.coerceIn(0.0..1.0).toFloat()
    }

    return Color.hsv(
        hue = hue(),
        saturation = saturation(),
        value = value()
    )
}

