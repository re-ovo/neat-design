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
import me.rerere.neat.theme.palette.ColorPalettes

@Preview(name = "Buttons", showBackground = true)
@Composable
fun ButtonPreview() {
    Column(
        modifier = Modifier.padding(32.dp)
    ) {
        Button(onClick = { /*TODO*/ }) {
            Text("按钮测试")
        }
    }
}

@Composable
fun Button(
    modifier: Modifier = Modifier,
    onClick: () -> Unit,
    content: @Composable () -> Unit
) {
    Box(
        modifier = modifier
            .clip(RoundedCornerShape(4.dp))
            .clickable(onClick = onClick)
            .background(ColorPalettes.Blue.day.COLOR_6)
    ) {
        Row(
            modifier = Modifier.padding(4.dp)
        ) {
            content()
        }
    }
}