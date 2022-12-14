package com.find.android.feature.presentation.main.home.component.barSheet

import android.util.Log
import androidx.compose.animation.core.animateFloat
import androidx.compose.animation.core.updateTransition
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.find.android.feature.presentation.main.home.HomeViewModel
import com.find.android.feature.util.extension.detectModeIcon
import java.util.*

enum class DynamicIslandState { Collapsed, Expanded }

@Composable
fun BoxScope.HomeBarDynamicIsland(
    viewModel: HomeViewModel,
    state: MutableState<DynamicIslandState>
) {

    val userModel = viewModel.userModel
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
        contentAlignment = Alignment.Center,
    ) {
        Log.d("LocationTest", "ada: $userModel")
        Row {
            Text("mode: ", style = MaterialTheme.typography.body2)
            Icon(painterResource(userModel.value.activityType.detectModeIcon()), contentDescription = "")
            Text(userModel.value.activityType.name.lowercase(Locale.getDefault()))
        }
    }
}