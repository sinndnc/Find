package com.find.android.feature.presentation.main.home.views

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.IntOffset
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.find.android.feature.presentation.main.home.component.barSheet.HomeAppBarProfileSheet
import com.find.android.feature.presentation.main.home.component.barSheet.HomeAppBarSettingSheet
import com.find.android.feature.presentation.main.home.component.bottomSheet.HomeBottomSheet

enum class BottomSheetState { Collapsed, Expanded }
enum class AppBarSheetState { Collapsed, Profile ,Setting}

@Composable
@OptIn(ExperimentalMaterialApi::class)
fun BoxScope.HomeBottomBar(
    navController: NavController,
    appBarProfileState: SwipeableState<AppBarSheetState>,
    appBarSettingState: SwipeableState<AppBarSheetState>,
    bottomState: SwipeableState<BottomSheetState>
) {

    Box(
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight()
            .align(Alignment.BottomCenter)
            .offset { IntOffset(0, bottomState.offset.value.toInt()) }
            .clip(RoundedCornerShape(topStart = 30.dp, topEnd = 30.dp))
            .background(Color.White),
    ) {
        HomeBottomSheet(bottomState)
    }

    Box(
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight()
            .align(Alignment.BottomCenter)
            .offset { IntOffset(0, appBarProfileState.offset.value.toInt()) }
            .clip(RoundedCornerShape(topStart = 30.dp, topEnd = 30.dp))
            .background(Color.White),
    ) {
        HomeAppBarProfileSheet(navController, appBarProfileState)
    }

    Box(
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight()
            .align(Alignment.BottomCenter)
            .offset { IntOffset(0, appBarSettingState.offset.value.toInt()) }
            .clip(RoundedCornerShape(topStart = 30.dp, topEnd = 30.dp))
            .background(Color.White),
    ) {
        HomeAppBarSettingSheet(navController, appBarSettingState)
    }

}

