package com.find.android.feature.presentation.main.home.component.bottomSheet

import androidx.compose.foundation.gestures.Orientation
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Divider
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.SwipeableState
import androidx.compose.material.swipeable
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.unit.dp
import com.find.android.feature.presentation.main.home.views.BottomSheetState

@Composable
@OptIn(ExperimentalMaterialApi::class)
fun BoxScope.HomeBottomSheet(
    bottomState: SwipeableState<BottomSheetState>,
) {

    val configuration = LocalConfiguration.current
    val screenHeight = configuration.screenHeightDp
    val bottomAnchors = mapOf(
        screenHeight * 1.0f to BottomSheetState.Expanded,
        screenHeight * 1.8f to BottomSheetState.Collapsed
    )

    Box(
        modifier = Modifier
            .align(Alignment.TopCenter)
            .fillMaxWidth()
            .fillMaxHeight(0.5f)
            .swipeable(
                state = bottomState,
                anchors = bottomAnchors,
                orientation = Orientation.Vertical
            ),
        contentAlignment = Alignment.TopCenter
    ) {
        Divider(
            modifier = Modifier
                .padding(vertical = 7.dp)
                .fillMaxWidth(0.38f)
                .clip(RoundedCornerShape(5.dp)),
            color = Color.Gray,
            thickness = 5.dp,
        )
        HomeBottomMenu()
    }


}