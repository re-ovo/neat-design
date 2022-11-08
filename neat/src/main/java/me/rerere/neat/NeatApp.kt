package me.rerere.neat

import androidx.compose.foundation.background
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import me.rerere.neat.theme.NeatTheme
import me.rerere.neat.theme.darkColorTheme
import me.rerere.neat.theme.lightColorTheme

@Composable
fun NeatApp(
    content: @Composable () -> Unit
) {
    NeatTheme(
        colorScheme = if(isSystemInDarkTheme()) lightColorTheme() else darkColorTheme()
    ) {
        content()
    }
}


@Composable
internal fun NeatPreview(
    content: @Composable () -> Unit
) {
    NeatApp {
        Box(
            modifier = Modifier
                .background(NeatTheme.colors.neutral.COLOR_1)
                .padding(16.dp)
        ) {
            content()
        }
    }
}