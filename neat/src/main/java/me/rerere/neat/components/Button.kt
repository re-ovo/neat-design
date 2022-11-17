package me.rerere.neat.components

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.Stable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import me.rerere.neat.NeatPreview
import me.rerere.neat.PreviewDayNight
import me.rerere.neat.layout.VerticalSpace
import me.rerere.neat.theme.LocalContentColor
import me.rerere.neat.theme.NeatTheme
import me.rerere.neat.util.bestContentColorFor

@PreviewDayNight
@Composable
internal fun ButtonPreview() {
    NeatPreview {
        VerticalSpace {
            ButtonType.values().forEach { buttonType ->
                Button(
                    onClick = { /*TODO*/ },
                    buttonType = buttonType,
                    loading = true
                ) {
                    Text("按钮测试: $buttonType")
                }
            }
            Button(
                onClick = { /*TODO*/ },
                loading = true
            ) {
                Text("按钮测试")
            }
        }
    }
}

enum class ButtonType {
    PRIMARY,
    SECONDARY,
    WARNING,
    ERROR,
}

@Composable
fun Button(
    modifier: Modifier = Modifier,
    onClick: () -> Unit,
    loading: Boolean = false,
    buttonType: ButtonType = ButtonType.PRIMARY,
    content: @Composable () -> Unit
) {
    val buttonColor = when (buttonType) {
        ButtonType.PRIMARY -> ButtonDefaults.primaryButtonColors()
        ButtonType.SECONDARY -> ButtonDefaults.secondaryButtonColors()
        ButtonType.WARNING -> ButtonDefaults.warningButtonColors()
        ButtonType.ERROR -> ButtonDefaults.errorButtonColors()
        else -> ButtonDefaults.primaryButtonColors()
    }
    Box(
        modifier = modifier
            .border(
                width = 1.dp,
                color = buttonColor.borderColor,
                shape = RoundedCornerShape(4.dp)
            )
            .clip(RoundedCornerShape(4.dp))
            .clickable(onClick = onClick)
            .background(buttonColor.backgroundColor)
    ) {
        Row(
            modifier = Modifier
                .height(IntrinsicSize.Min)
                .padding(ButtonDefaults.ButtonPadding),
            horizontalArrangement = Arrangement.spacedBy(8.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            if(loading) {
                Spin(
                    color = buttonColor.contentColor,
                    modifier = Modifier
                        .size(16.dp),
                    strokeWidth = 2.dp
                )
            }
            CompositionLocalProvider(LocalContentColor provides buttonColor.contentColor) {
                content()
            }
        }
    }
}

@Stable
class ButtonColors(
    val contentColor: Color,
    val backgroundColor: Color,
    val borderColor: Color,
    val disabledContentColor: Color,
    val disabledBackgroundColor: Color
)

internal object ButtonDefaults {
    val ButtonPadding = 8.dp

    @Composable
    fun primaryButtonColors(): ButtonColors {
        return ButtonColors(
            contentColor = NeatTheme.colors.neutral[1],
            backgroundColor = NeatTheme.colors.primary[6],
            borderColor = NeatTheme.colors.primary[6],
            disabledContentColor = NeatTheme.colors.neutral[1],
            disabledBackgroundColor = NeatTheme.colors.primary[6]
        )
    }

    @Composable
    fun secondaryButtonColors(): ButtonColors {
        return ButtonColors(
            contentColor = NeatTheme.colors.neutral[10],
            backgroundColor = NeatTheme.colors.neutral[1],
            borderColor = NeatTheme.colors.neutral[5],
            disabledContentColor = NeatTheme.colors.neutral[1],
            disabledBackgroundColor = NeatTheme.colors.primary[6]
        )
    }

    @Composable
    fun warningButtonColors(): ButtonColors {
        return ButtonColors(
            contentColor = NeatTheme.colors.neutral[1],
            backgroundColor = NeatTheme.colors.warning[6],
            borderColor = NeatTheme.colors.warning[6],
            disabledContentColor = NeatTheme.colors.neutral[1],
            disabledBackgroundColor = NeatTheme.colors.primary[6]
        )
    }

    @Composable
    fun errorButtonColors(): ButtonColors {
        return ButtonColors(
            contentColor = NeatTheme.colors.neutral[1],
            backgroundColor = NeatTheme.colors.error[6],
            borderColor = NeatTheme.colors.error[6],
            disabledContentColor = NeatTheme.colors.neutral[1],
            disabledBackgroundColor = NeatTheme.colors.primary[6]
        )
    }
}