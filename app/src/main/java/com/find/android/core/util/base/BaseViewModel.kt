package com.find.android.core.util.base

import android.app.Activity
import androidx.lifecycle.ViewModel
import com.find.android.core.domain.repository.ActivityRecognitionRepository
import com.find.android.core.domain.repository.LocationRepository
import com.find.android.core.domain.usecase.user.UserUseCase
import javax.inject.Inject

abstract class BaseViewModel : ViewModel() {

    @Inject
    protected lateinit var userUseCase: UserUseCase

    @Inject
    protected lateinit var locationRepository: LocationRepository

    @Inject
    protected lateinit var activityRecognitionRepository: ActivityRecognitionRepository

    val userModel get() = userUseCase.remoteUserModel

    val currentActivity get() = activityRecognitionRepository.currentActivity

    fun getCurrentLocation() = locationRepository.getCurrentLocation()

    fun requestLocationUpdates() = locationRepository.requestLocationUpdates()

    fun startLocationService(activity: Activity) =
        activityRecognitionRepository.startActivityRecognitionService(activity)

    fun stopLocationService(activity: Activity) =
        activityRecognitionRepository.stopActivityRecognitionService(activity)

}