package com.find.android.core.util.base

import android.app.Activity
import androidx.compose.runtime.MutableState
import androidx.lifecycle.ViewModel
import com.find.android.core.domain.model.RemoteUserModel
import com.find.android.core.domain.repository.ActivityRecognitionRepository
import com.find.android.core.domain.repository.LocationRepository
import javax.inject.Inject

abstract class BaseViewModel : ViewModel() {

    @Inject
    protected lateinit var locationRepository: LocationRepository

    @Inject
    protected lateinit var activityRecognitionRepository: ActivityRecognitionRepository

    abstract val userModel: MutableState<RemoteUserModel>

    abstract val friendList: MutableList<RemoteUserModel>

    fun getCurrentLocation() = locationRepository.getCurrentLocation()

    fun requestLocationUpdates() = locationRepository.requestLocationUpdates()

    fun startLocationService(activity: Activity) =
        activityRecognitionRepository.startActivityRecognitionService(activity)

    fun stopLocationService(activity: Activity) =
        activityRecognitionRepository.stopActivityRecognitionService(activity)

}