package me.rerere.neat

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import me.rerere.neat.theme.NeatTheme

@Composable
fun NeatApp(
    content: @Composable () -> Unit
) {
    NeatTheme {
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

@Preview(
    showBackground = true
)
@Preview(
    showBackground = true,
    uiMode = android.content.res.Configuration.UI_MODE_NIGHT_YES
)
annotation class PreviewDayNight