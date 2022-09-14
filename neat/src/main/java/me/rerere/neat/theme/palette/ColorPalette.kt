package me.rerere.neat.theme.palette

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.BasicText
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import me.rerere.neat.util.hexValue

interface ColorPalette {
    val PRIMARY: Color get() = this.getColor(6)
    val COLOR_1: Color get() = this.getColor(1)
    val COLOR_2: Color get() = this.getColor(2)
    val COLOR_3: Color get() = this.getColor(3)
    val COLOR_4: Color get() = this.getColor(4)
    val COLOR_5: Color get() = this.getColor(5)
    val COLOR_6: Color get() = this.getColor(6)
    val COLOR_7: Color get() = this.getColor(7)
    val COLOR_8: Color get() = this.getColor(8)
    val COLOR_9: Color get() = this.getColor(9)
    val COLOR_10: Color get() = this.getColor(10)

    fun getColor(index: Int): Color
}

interface DayNightPalette {
    val day: ColorPalette
    val night: ColorPalette
}

@Composable
internal fun ColorPalettePreview(colorPalette: DayNightPalette) {
    Row(
        modifier = Modifier
            .padding(1.dp)
            .wrapContentSize()
    ) {
        Column {
            repeat(10) { i ->
                val realIndex = i + 1
                Box(
                    modifier = Modifier
                        .width(50.dp)
                        .aspectRatio(16 / 9f)
                        .background(colorPalette.day.getColor(realIndex))
                ) {
                    //BasicText(colorPalette.day.getColor(realIndex).hexValue)
                }
            }
        }
        Column {
            repeat(10) { i ->
                val realIndex = i + 1
                Box(
                    modifier = Modifier
                        .width(50.dp)
                        .aspectRatio(16 / 9f)
                        .background(colorPalette.night.getColor(realIndex))
                ) {
                   // BasicText(colorPalette.night.getColor(realIndex).hexValue)
                }
            }
        }
    }
}