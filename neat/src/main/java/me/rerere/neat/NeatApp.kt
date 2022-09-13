package me.rerere.neat

import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.staticCompositionLocalOf

@Composable
fun NeatApp(
    content: @Composable () -> Unit
) {
    CompositionLocalProvider() {
        content()
    }
}
