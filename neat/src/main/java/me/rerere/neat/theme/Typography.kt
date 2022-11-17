package me.rerere.neat.theme

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.text.BasicText
import androidx.compose.runtime.Composable
import androidx.compose.runtime.Immutable
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import me.rerere.neat.NeatPreview

val LocalTypography = staticCompositionLocalOf { Typography() }

@Immutable
class Typography(
    val bodyNormal: TextStyle = TextStyle(
        fontFamily = FontFamily.SansSerif,
        fontWeight = FontWeight.Normal,
        fontSize = 18.sp
    ),
    val bodySmall: TextStyle = TextStyle(
        fontFamily = FontFamily.SansSerif,
        fontWeight = FontWeight.Normal,
        fontSize = 16.sp
    ),
    val bodyTiny: TextStyle = TextStyle(
        fontFamily = FontFamily.SansSerif,
        fontWeight = FontWeight.Normal,
        fontSize = 14.sp
    ),
    val titleSmall: TextStyle = TextStyle(
        fontFamily = FontFamily.SansSerif,
        fontWeight = FontWeight.Normal,
        fontSize = 20.sp
    ),
    val titleMedium: TextStyle = TextStyle(
        fontFamily = FontFamily.SansSerif,
        fontWeight = FontWeight.Normal,
        fontSize = 23.sp
    ),
    val titleLarge: TextStyle = TextStyle(
        fontFamily = FontFamily.SansSerif,
        fontWeight = FontWeight.Normal,
        fontSize = 26.sp
    ),
    val displaySmall: TextStyle = TextStyle(
        fontFamily = FontFamily.SansSerif,
        fontWeight = FontWeight.Normal,
        fontSize = 32.sp
    ),
    val displayMedium: TextStyle = TextStyle(
        fontFamily = FontFamily.SansSerif,
        fontWeight = FontWeight.Normal,
        fontSize = 40.sp
    ),
    val displayLarge: TextStyle = TextStyle(
        fontFamily = FontFamily.SansSerif,
        fontWeight = FontWeight.Normal,
        fontSize = 48.sp
    ),
)

@Preview
@Composable
fun TypographyPreview() {
    NeatPreview {
        Column {
            BasicText("Default 对照")
            
            BasicText(
                text = "Body Normal",
                style = LocalTypography.current.bodyNormal
            )
            BasicText(
                text = "Body Small",
                style = LocalTypography.current.bodySmall
            )
            BasicText(
                text = "Body Tiny",
                style = LocalTypography.current.bodyTiny
            )
            BasicText(
                text = "Title 1",
                style = LocalTypography.current.titleSmall
            )
            BasicText(
                text = "Title 2",
                style = LocalTypography.current.titleMedium
            )
            BasicText(
                text = "Title 3",
                style = LocalTypography.current.titleLarge
            )
            BasicText(
                text = "Display 1",
                style = LocalTypography.current.displaySmall
            )
            BasicText(
                text = "Display 2",
                style = LocalTypography.current.displayMedium
            )
            BasicText(
                text = "Display 3",
                style = LocalTypography.current.displayLarge
            )
        }
    }
}