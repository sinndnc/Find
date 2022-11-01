package com.find.android.feature.presentation.main.home

import android.app.Activity
import android.content.Intent
import android.content.IntentSender
import android.location.Location
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.IntentSenderRequest
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.SwipeableState
import androidx.compose.runtime.MutableState
import androidx.lifecycle.ViewModel
import com.find.android.FindActivity
import com.find.android.core.domain.usecase.location.map.LocationHelper
import com.find.android.core.domain.usecase.location.setting.LocationSettingHelper
import com.find.android.core.domain.usecase.user.UserHelper
import com.find.android.core.util.location.LocationService
import com.find.android.core.util.recognition.ActivityDetectService
import com.find.android.feature.presentation.main.home.views.AppBarSheetState
import com.google.android.gms.common.api.ResolvableApiException
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
@OptIn(ExperimentalMaterialApi::class)
class HomeViewModel @Inject constructor(
    userHelper: UserHelper,
    locationHelper: LocationHelper,
    private val locationSettingHelper: LocationSettingHelper,
    private val activityDetectService: ActivityDetectService,
) : ViewModel() {

    init {
        userHelper.getUserInformation()
    }

    val userInfo = userHelper.userModel
    val currentLocation : MutableState<Location?> = locationHelper.currentLocation

    suspend fun clickToProfile(state: SwipeableState<AppBarSheetState>) {
        state.animateTo(AppBarSheetState.Profile)
    }

    suspend fun clickToSetting(state: SwipeableState<AppBarSheetState>) {
        state.animateTo(AppBarSheetState.Setting)
    }

    fun startLocationService(activity: Activity) {
        activityDetectService.requestActivityTransitionUpdates(activity as FindActivity)
        activity.startForegroundService(Intent(activity, LocationService::class.java))
    }

    fun stopLocationService(activity: Activity) {
        activity.stopService(Intent(activity, LocationService::class.java))
    }

    fun checkLocationIsEnabled(resultLauncher: ActivityResultLauncher<IntentSenderRequest>, activity: Activity) {
        locationSettingHelper.checkLocationIsEnabled().onEach { result ->
            result.onSuccess {
                startLocationService(activity)
            }.onError { exception ->
                if (exception is ResolvableApiException) {
                    try {
                        val intentSenderRequest = IntentSenderRequest.Builder(exception.resolution).build()
                        resultLauncher.launch(intentSenderRequest)
                    } catch (_: IntentSender.SendIntentException) {

                    }
                }
            }
        }.launchIn(CoroutineScope(Dispatchers.IO))
    }


}

