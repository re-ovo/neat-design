package me.rerere.neat.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.text.TextStyle
import me.rerere.neat.components.LocalTextStyle

@Composable
fun NeatTheme(
    colorScheme: ColorScheme = if(!isSystemInDarkTheme()) lightColorTheme() else darkColorTheme(),
    typography: Typography = Typography(),
    content: @Composable () -> Unit
) {
    CompositionLocalProvider(
        LocalColorTheme provides colorScheme,
        LocalContentColor provides colorScheme.neutral[10],
        LocalTypography provides typography,
        LocalTextStyle provides typography.bodyNormal
    ) {
        content()
    }
}

object NeatTheme {
    val colors: ColorScheme
        @Composable
        get() = LocalColorTheme.current

    val typography: Typography
        @Composable
        get() = LocalTypography.current
}

