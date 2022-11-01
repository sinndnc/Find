package com.find.android.feature.presentation.main.home.component.barSheet

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
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.find.android.feature.presentation.main.home.views.AppBarSheetState
import com.find.android.feature.presentation.main.profile.ProfileContent
import com.find.android.feature.presentation.main.profile.ProfileViewModel

@Composable
@OptIn(ExperimentalMaterialApi::class)
fun HomeAppBarProfileSheet(
    navController: NavController,
    appBarProfileState: SwipeableState<AppBarSheetState>,
) {

    val configuration = LocalConfiguration.current
    val screenHeight = configuration.screenHeightDp
    val profileIsEnabled = when (appBarProfileState.direction) {
        -1f -> false
        else -> true
    }

    val appBarProfileAnchors = mapOf(
        screenHeight * 2.0f to AppBarSheetState.Collapsed,
        screenHeight * 0.002f to AppBarSheetState.Profile
    )

    Box(
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight()
            .swipeable(
                state = appBarProfileState,
                enabled = profileIsEnabled,
                anchors = appBarProfileAnchors,
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
        val profileViewModel = hiltViewModel<ProfileViewModel>()
        ProfileContent(profileViewModel, navController, appBarProfileState)
    }
}