package com.find.android.feature.presentation.main.home.component.barSheet

import androidx.compose.animation.core.animateFloat
import androidx.compose.animation.core.updateTransition
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

enum class DynamicIslandState { Collapsed, Expanded }

@Composable
fun BoxScope.HomeBarDynamicIsland(state: MutableState<DynamicIslandState>) {

    val transition = updateTransition(state, label = "DynamicIsland")
    val height = transition.animateFloat(label = "DynamicIslandAnimateHeight") { dynamicIslandState ->
        when (dynamicIslandState.value) {
            DynamicIslandState.Collapsed -> 0.05F
            DynamicIslandState.Expanded -> 0.1F
        }
    }
    val width = transition.animateFloat(label = "DynamicIslandAnimateWidth") { dynamicIslandState ->
        when (dynamicIslandState.value) {
            DynamicIslandState.Collapsed -> 0.5F
            DynamicIslandState.Expanded -> 0.65F
        }
    }

    Box(
        modifier = Modifier
            .padding(10.dp)
            .statusBarsPadding()
            .align(Alignment.TopCenter)
            .fillMaxWidth(width.value)
            .fillMaxHeight(height.value)
            .clip(RoundedCornerShape(20.dp))
            .background(Color.White)
            .clickable {
                state.value = if (state.value == DynamicIslandState.Expanded)
                    DynamicIslandState.Collapsed else DynamicIslandState.Expanded
            },
    ) {

    }
}