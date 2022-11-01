package com.find.android.feature.presentation.main.home.views

import androidx.compose.animation.core.*
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.SwipeableState
import androidx.compose.runtime.*
import com.find.android.feature.component.theme.Blue500
import com.find.android.feature.presentation.main.home.HomeViewModel
import com.find.android.feature.presentation.main.home.component.barSheet.DynamicIslandState
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.model.CameraPosition
import com.google.android.gms.maps.model.LatLng
import com.google.maps.android.compose.*
import kotlinx.coroutines.launch

@Composable
@OptIn(ExperimentalMaterialApi::class)
fun HomeBody(
    viewModel: HomeViewModel,
    dynamicIslandState: MutableState<DynamicIslandState>,
    bottomState: SwipeableState<BottomSheetState>
) {

    val coroutineScope = rememberCoroutineScope()
    val cameraPositionState = rememberCameraPositionState(
        init = {
            CameraPosition.fromLatLngZoom(LatLng(40.655659, 29.281441), 15f)
        }
    )

    LaunchedEffect(Unit) {
        cameraPositionState.animate(
            update = CameraUpdateFactory.newCameraPosition(
                CameraPosition(LatLng(40.655659, 29.281441), 16f, 0f, 0f)
            ),
        )
    }

    val infiniteTransition = rememberInfiniteTransition()
    val scale by infiniteTransition.animateFloat(
        initialValue = 20.0.toFloat(),
        targetValue = 25.0.toFloat(),
        animationSpec = infiniteRepeatable(
            animation = tween(1500),
            repeatMode = RepeatMode.Reverse
        )
    )

    var currentLocation by remember { mutableStateOf(viewModel.currentLocation.value) }
    val transitionLatitude = updateTransition(currentLocation, label = "")

    GoogleMap(
        cameraPositionState = cameraPositionState,
        uiSettings = MapUiSettings(
            zoomControlsEnabled = false,
            compassEnabled = false,
            myLocationButtonEnabled = false,
            mapToolbarEnabled = false,
        ),
        onMapClick = {
            coroutineScope.launch {
                onMapClick(dynamicIslandState, bottomState)
            }
        }
    ) {
        viewModel.currentLocation.value?.let {
            Circle(
                center = LatLng(it.latitude,it.longitude),
                clickable = false,
                fillColor = Blue500.copy(0.1f),
                radius = scale.toDouble(),
                strokeColor = Blue500.copy(0.2f),
                strokeWidth = 3.0f,
            )
            Marker(
                state = MarkerState(LatLng(it.latitude, it.longitude)),

                )
        }

    }
}

@OptIn(ExperimentalMaterialApi::class)
private suspend fun onMapClick(
    dynamicIslandState: MutableState<DynamicIslandState>,
    bottomState: SwipeableState<BottomSheetState>
) {
    when {
        dynamicIslandState.value != DynamicIslandState.Collapsed -> {
            dynamicIslandState.value = DynamicIslandState.Collapsed
        }
        bottomState.currentValue != BottomSheetState.Collapsed -> {
            bottomState.animateTo(BottomSheetState.Collapsed)
        }
    }
}

