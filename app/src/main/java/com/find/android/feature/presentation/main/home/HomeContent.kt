package com.find.android.feature.presentation.main.home

import android.app.Activity.RESULT_OK
import androidx.activity.compose.BackHandler
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.layout.Box
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.rememberSwipeableState
import androidx.compose.runtime.*
import androidx.compose.ui.platform.LocalContext
import androidx.navigation.NavController
import com.find.android.FindActivity
import com.find.android.core.util.recognition.enums.DetectedActivityEnum
import com.find.android.feature.presentation.main.home.component.barSheet.DynamicIslandState
import com.find.android.feature.presentation.main.home.component.barSheet.HomeBarDynamicIsland
import com.find.android.feature.presentation.main.home.views.*
import com.find.android.feature.util.event.LifeCycleEvent
import kotlinx.coroutines.launch

@Composable
@OptIn(ExperimentalMaterialApi::class)
fun HomeContent(viewModel: HomeViewModel, navController: NavController) {

    val coroutineScope = rememberCoroutineScope()
    val activity = LocalContext.current as FindActivity
    val dynamicIslandState = remember { mutableStateOf(DynamicIslandState.Collapsed) }
    val bottomState = rememberSwipeableState(initialValue = BottomSheetState.Collapsed)
    val appBarProfileState = rememberSwipeableState(initialValue = AppBarSheetState.Collapsed)
    val appBarSettingState = rememberSwipeableState(initialValue = AppBarSheetState.Collapsed)
    val resultLauncher = rememberLauncherForActivityResult(ActivityResultContracts.StartIntentSenderForResult()) { result ->
        if (result.resultCode == RESULT_OK) {
            viewModel.startLocationService(activity)
            if (viewModel.userModel.value.activityType == DetectedActivityEnum.STILL)
                viewModel.getCurrentLocation()
            else
                viewModel.requestLocationUpdates()
        }
    }

    LifeCycleEvent(
        onStart = { viewModel.checkLocationIsEnabled(resultLauncher, activity) },
        onStop = { viewModel.stopLocationService(activity) })

    Box {
        HomeBody(viewModel, bottomState, dynamicIslandState)
        HomeBarDynamicIsland(viewModel, dynamicIslandState)
        HomeAppBar(viewModel, appBarSettingState, appBarProfileState)
        HomeBottomBar(navController, appBarProfileState, appBarSettingState, bottomState)
    }

    BackHandler {
        when {
            appBarProfileState.currentValue != AppBarSheetState.Collapsed -> {
                coroutineScope.launch {
                    appBarProfileState.animateTo(AppBarSheetState.Collapsed)
                }
            }
            appBarSettingState.currentValue != AppBarSheetState.Collapsed -> {
                coroutineScope.launch {
                    appBarSettingState.animateTo(AppBarSheetState.Collapsed)
                }
            }
            bottomState.currentValue != BottomSheetState.Collapsed -> {
                coroutineScope.launch {
                    bottomState.animateTo(BottomSheetState.Collapsed)
                }
            }
            else -> {
                activity.finish()
            }
        }
    }
}


