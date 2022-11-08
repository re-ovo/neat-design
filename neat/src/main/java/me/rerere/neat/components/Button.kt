package me.rerere.neat.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import me.rerere.neat.NeatPreview
import me.rerere.neat.theme.NeatTheme
import me.rerere.neat.theme.palette.ColorPalettes

@Preview(name = "Buttons", showBackground = true)
@Composable
internal fun ButtonPreview() {
    NeatPreview {
        Button(onClick = { /*TODO*/ }) {
            Text("按钮测试")
        }
    }
}

enum class ButtonType {
    DEFAULT,
    TERIARY,
    PRIMARY,
    INFO,
    SUCCESS,
    WARNING,
    ERROR
}

@Composable
fun Button(
    modifier: Modifier = Modifier,
    onClick: () -> Unit,
    loading: Boolean = false,
    type: ButtonType = ButtonType.DEFAULT,
    textButton: Boolean = false,
    content: @Composable () -> Unit
) {
    Box(
        modifier = modifier
            .clip(RoundedCornerShape(4.dp))
            .clickable(onClick = onClick)
            .background(NeatTheme.colors.primary.PRIMARY)
    ) {
        Row(
            modifier = Modifier.padding(6.dp)
        ) {
            content()
        }
    }
}

internal object ButtonThemeToken {

}