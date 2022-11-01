package com.find.android.feature.presentation.main.home.component.barSheet

import androidx.compose.foundation.gestures.Orientation
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
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
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.find.android.feature.presentation.main.home.views.AppBarSheetState
import com.find.android.feature.presentation.main.setting.SettingsContent
import com.find.android.feature.presentation.main.setting.SettingsViewModel

@Composable
@OptIn(ExperimentalMaterialApi::class)
fun HomeAppBarSettingSheet(
    navController: NavController,
    appBarSettingState: SwipeableState<AppBarSheetState>
) {

    val configuration = LocalConfiguration.current
    val screenHeight = configuration.screenHeightDp
    val settingIsEnabled = when (appBarSettingState.direction) {
        -1f -> false
        else -> true
    }

    val appBarSettingAnchors = mapOf(
        screenHeight * 2.0f to AppBarSheetState.Collapsed,
        screenHeight * 0.002f to AppBarSheetState.Setting
    )

    Box(
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight()
            .swipeable(
                state = appBarSettingState,
                enabled = settingIsEnabled,
                anchors = appBarSettingAnchors,
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
        val settingViewModel = hiltViewModel<SettingsViewModel>()
        SettingsContent(settingViewModel, navController, appBarSettingState)
    }

}