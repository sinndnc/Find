package com.find.android.feature.util.extension

import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.AnimationVector1D
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.gestures.DraggableState
import androidx.compose.foundation.gestures.Orientation
import androidx.compose.foundation.gestures.draggable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.offset
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.composed
import androidx.compose.ui.unit.IntOffset
import kotlinx.coroutines.launch
import kotlin.math.roundToInt

fun Modifier.setThemeBackground(): Modifier = composed {
    this.then(background(MaterialTheme.colors.background))
}

inline fun Modifier.noRippleClickable(crossinline onClick: () -> Unit): Modifier = composed {
    clickable(indication = null,
        interactionSource = remember { MutableInteractionSource() }) {
        onClick()
    }
}

fun Modifier.verticalDraggable(state: DraggableState, y: Animatable<Float, AnimationVector1D>): Modifier {
    return draggable(
        state = state,
        orientation = Orientation.Vertical,
        onDragStopped = {
            launch {
                y.animateTo(
                    targetValue = 0f,
                    animationSpec = tween(
                        durationMillis = 400,
                        delayMillis = 0
                    )
                )
            }
        },
    )
}

fun Modifier.verticalIntOffset(
    offsetY: Animatable<Float, AnimationVector1D>,
    minimumValue: Float,
    maximumValue: Float
): Modifier {
    return offset {
        IntOffset(
            0, offsetY.value
                .coerceIn(minimumValue, maximumValue)
                .roundToInt()
        )
    }
}