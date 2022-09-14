package me.rerere.neat.theme.palette

import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview

/**
 * 预定义了一些基础的调色板
 */
object ColorPalettes {
    val Red = DynamicColorPalette(Color(0xFFF53F3F))
    val OrangeRed = DynamicColorPalette(Color(0xFFF77234))
    val Orange = DynamicColorPalette(Color(0xFFFF7D00))
    val Gold = DynamicColorPalette(Color(0xFFF7BA1E))
    val Yellow = DynamicColorPalette(Color(0xFFFADC19))
    val Lime = DynamicColorPalette(Color(0xFF9FDB1D))
    val Green = DynamicColorPalette(Color(0xFF00B42A))
    val Cyan = DynamicColorPalette(Color(0xFF14C9C9))
    val Blue = DynamicColorPalette(Color(0xFF3491FA))
    val Purple = DynamicColorPalette(Color(0xFF722ED1))
    val PinkPurple = DynamicColorPalette(Color(0xFFD91AD9))
    val Magenta = DynamicColorPalette(Color(0xFFF5319D))
    val Grey = StaticColorPalette(
        lightColors = listOf(
            Color(0xfff7f8fa),
            Color(0xfff2f3f5),
            Color(0xffe5e6eb),
            Color(0xffc9cdd4),
            Color(0xffa9aeb8),
            Color(0xff86909c),
            Color(0xff6b7785),
            Color(0xff4e5969),
            Color(0xff272e3b),
            Color(0xff1d2129)
        ),
        darkColors = listOf(
            Color(0xff17171a),
            Color(0xff2e2e30),
            Color(0xff484849),
            Color(0xff5f5f60),
            Color(0xff78787a),
            Color(0xff929293),
            Color(0xffababac),
            Color(0xffc5c5c5),
            Color(0xffdfdfdf),
            Color(0xfff6f6f6)
        )
    )
}

@Preview(
    name = "调色板预览",
    showBackground = true
)
@Composable
internal fun ColorPalettesPreview() {
    Column {
        ColorPalettePreview(ColorPalettes.Red)
        ColorPalettePreview(ColorPalettes.Green)
        ColorPalettePreview(ColorPalettes.Blue)
        ColorPalettePreview(ColorPalettes.Grey)
    }
}