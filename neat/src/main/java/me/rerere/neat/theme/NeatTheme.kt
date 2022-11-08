package me.rerere.neat.theme

import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.staticCompositionLocalOf

@Composable
fun NeatTheme(
    colorScheme: ColorScheme,
    content: @Composable () -> Unit
) {
    CompositionLocalProvider(
        LocalColorTheme provides colorScheme,
    ) {
        content()
    }
}

object NeatTheme {
    val colors: ColorScheme
        @Composable
        get() = LocalColorTheme.current
}

val LocalColorTheme = staticCompositionLocalOf { lightColorTheme() }