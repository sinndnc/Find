package com.find.android.feature.presentation.main.home.views

import android.util.Log
import androidx.compose.animation.core.*
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.SwipeableState
import androidx.compose.runtime.*
import androidx.compose.ui.platform.LocalContext
import com.find.android.R
import com.find.android.core.util.recognition.enums.DetectedActivityEnum
import com.find.android.feature.component.theme.Blue500
import com.find.android.feature.presentation.main.home.HomeViewModel
import com.find.android.feature.presentation.main.home.component.barSheet.DynamicIslandState
import com.find.android.feature.util.extension.convertToBitmap
import com.find.android.feature.util.extension.getCroppedBitmap
import com.find.android.feature.util.extension.toLatLng
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMapOptions
import com.google.android.gms.maps.model.BitmapDescriptorFactory
import com.google.android.gms.maps.model.CameraPosition
import com.google.android.gms.maps.model.MapStyleOptions
import com.google.maps.android.compose.*
import kotlinx.coroutines.launch

@Composable
@OptIn(ExperimentalMaterialApi::class)
fun HomeBody(
    viewModel: HomeViewModel, dynamicIslandState: MutableState<DynamicIslandState>, bottomState: SwipeableState<BottomSheetState>
) {

    val context = LocalContext.current
    val coroutineScope = rememberCoroutineScope()
    val currentActivity by remember { viewModel.activityRecognitionRepository.currentActivity }
    val currentLocation by remember { viewModel.locationRepository.currentLocation }
    val cameraPositionState = rememberCameraPositionState {
        position = CameraPosition.fromLatLngZoom(currentLocation.toLatLng(), 16f)
    }

    DisposableEffect(currentActivity) {
        Log.d("LocationTest", "Disposable $currentActivity")
        when (currentActivity) {
            DetectedActivityEnum.STILL -> viewModel.locationRepository.getCurrentLocation()
            else -> viewModel.locationRepository.requestLocationUpdates()
        }
        onDispose {  }
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
        Marker(
            icon = BitmapDescriptorFactory.fromBitmap(
                viewModel.userUseCase.userModel.value.image!!.convertToBitmap().getCroppedBitmap()!!
            ),
            state = MarkerState(currentLocation.toLatLng()),
            onClick = {
                coroutineScope.launch {
                    cameraPositionState.animate(CameraUpdateFactory.newLatLngZoom(currentLocation.toLatLng(), 16f))
                }
                true
            },
        )

    }


}

@OptIn(ExperimentalMaterialApi::class)
private suspend fun onMapClick(
    dynamicIslandState: MutableState<DynamicIslandState>, bottomState: SwipeableState<BottomSheetState>
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

