package me.rerere.neat.layout

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

enum class SpaceSize(val value: Dp) {
    SMALL(4.dp),
    MEDIUM(8.dp),
    LARGE(16.dp)
}

@Composable
fun VerticalSpace(
    modifier: Modifier = Modifier,
    size: SpaceSize = SpaceSize.SMALL,
    content: @Composable () -> Unit
) {
    Column(
        modifier = Modifier,
        verticalArrangement = Arrangement.spacedBy(size.value)
    ) {
        content()
    }
}

@Composable
fun HorizontalSpace(
    modifier: Modifier = Modifier,
    size: SpaceSize = SpaceSize.SMALL,
    content: @Composable () -> Unit
) {
    Row(
        modifier = Modifier,
        horizontalArrangement = Arrangement.spacedBy(size.value)
    ) {
        content()
    }
}