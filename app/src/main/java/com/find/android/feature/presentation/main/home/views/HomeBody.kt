package com.find.android.feature.presentation.main.home.views

import android.util.Log
import androidx.compose.animation.core.*
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.SwipeableState
import androidx.compose.runtime.*
import androidx.compose.ui.platform.LocalContext
import com.find.android.R
import com.find.android.core.util.recognition.enums.DetectedActivityEnum
import com.find.android.feature.presentation.main.home.HomeViewModel
import com.find.android.feature.presentation.main.home.component.barSheet.DynamicIslandState
import com.find.android.feature.util.extension.toLatLng
import com.find.android.feature.util.extension.toLocationModel
import com.google.android.gms.maps.model.CameraPosition
import com.google.android.gms.maps.model.MapStyleOptions
import com.google.maps.android.compose.*
import kotlinx.coroutines.launch

@Composable
@OptIn(ExperimentalMaterialApi::class)
fun HomeBody(
    viewModel: HomeViewModel,
    bottomState: SwipeableState<BottomSheetState>,
    dynamicIslandState: MutableState<DynamicIslandState>,
) {
    val context = LocalContext.current
    val coroutineScope = rememberCoroutineScope()
    val userModel by remember { viewModel.userModel }
    val currentActivity = viewModel.userModel.value.activityType
    val currentLocation = viewModel.userModel.value.location?.toLocationModel()
    val cameraPositionState = rememberCameraPositionState {
        if (currentLocation != null) {
            position = CameraPosition.fromLatLngZoom(currentLocation.toLatLng(), 16f)
        }
    }

    /*
    val longitude by animateFloatAsState(
        targetValue = currentLocation.longitude.toFloat(),
        animationSpec = tween(
            durationMillis = 800,
            easing = LinearEasing
        )
    )

    val latitude by animateFloatAsState(
        targetValue = currentLocation.latitude.toFloat(),
        animationSpec = tween(
            durationMillis = 800,
            easing = LinearEasing
        )
    )
     */

    DisposableEffect(currentActivity) {
        when (currentActivity) {
            DetectedActivityEnum.STILL -> viewModel.getCurrentLocation()
            else -> viewModel.requestLocationUpdates()
        }
        onDispose { }
    }

    GoogleMap(
        cameraPositionState = cameraPositionState,
        uiSettings = MapUiSettings(
            zoomControlsEnabled = false,
            compassEnabled = false,
            myLocationButtonEnabled = false,
            mapToolbarEnabled = false,
        ),
        properties = MapProperties(
            mapStyleOptions = MapStyleOptions.loadRawResourceStyle(context, R.raw.find_light_map),
        ),
        onMapClick = {
            coroutineScope.launch {
                onMapClick(dynamicIslandState, bottomState)
            }
        },
    ) {
        Log.d("UserTest", "homeBody: $userModel")
        /*
        Marker(
            icon = BitmapDescriptorFactory.fromBitmap(
                viewModel.userUseCase.userModel.value.image!!.convertToBitmap().getCroppedBitmap()!!
            ),
            state = MarkerState(LatLng(latitude.toDouble(), longitude.toDouble())),
            onClick = {
                coroutineScope.launch {
                    cameraPositionState.animate(CameraUpdateFactory.newLatLngZoom(currentLocation.toLatLng(), 16f))
                }
                true
            },
        )

         */
    }
}

@OptIn(ExperimentalMaterialApi::class)
private suspend fun onMapClick(
    dynamicIslandState: MutableState<DynamicIslandState>, bottomState: SwipeableState<BottomSheetState>
) {
    dynamicIslandState.value = DynamicIslandState.Collapsed
    bottomState.animateTo(BottomSheetState.Collapsed)
}

