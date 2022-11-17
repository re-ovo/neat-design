package me.rerere.neat.components

import androidx.compose.animation.core.LinearEasing
import androidx.compose.animation.core.VectorConverter
import androidx.compose.animation.core.animateValue
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.rememberInfiniteTransition
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.defaultMinSize
import androidx.compose.foundation.layout.requiredSize
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.progressSemantics
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import me.rerere.neat.NeatPreview
import me.rerere.neat.PreviewDayNight
import me.rerere.neat.theme.NeatTheme

@PreviewDayNight
@Composable
fun SpinPreview() {
    NeatPreview {
        Spin()
    }
}

@Composable
fun Spin(
    modifier: Modifier = Modifier,
    color: Color = NeatTheme.colors.primary[6],
    strokeWidth: Dp = 4.dp
) {
    val transition = rememberInfiniteTransition()
    val currentRotation = transition.animateValue(
        initialValue = 0,
        targetValue = 360,
        Int.VectorConverter,
        infiniteRepeatable(
            animation = tween(
                durationMillis = 1000,
                easing = LinearEasing
            )
        )
    )
    Canvas(
        modifier = modifier
            .defaultMinSize(48.dp)
            .progressSemantics()
            .graphicsLayer {
                rotationZ = currentRotation.value.toFloat()
            },
        onDraw = {
            drawArc(
                color = color,
                startAngle = 0f,
                sweepAngle = 270f,
                useCenter = false,
                style = Stroke(strokeWidth.toPx())
            )
        }
    )
}