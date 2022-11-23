package com.find.android.core.util.base

import android.app.Activity
<<<<<<< HEAD
import androidx.compose.runtime.MutableState
import androidx.lifecycle.ViewModel
import com.find.android.core.domain.model.RemoteUserModel
import com.find.android.core.domain.repository.ActivityRecognitionRepository
import com.find.android.core.domain.repository.LocationRepository
=======
import androidx.lifecycle.ViewModel
import com.find.android.core.domain.repository.ActivityRecognitionRepository
import com.find.android.core.domain.repository.LocationRepository
import com.find.android.core.domain.usecase.user.UserUseCase
>>>>>>> origin/master
import javax.inject.Inject

abstract class BaseViewModel : ViewModel() {

    @Inject
<<<<<<< HEAD
=======
    protected lateinit var userUseCase: UserUseCase

    @Inject
>>>>>>> origin/master
    protected lateinit var locationRepository: LocationRepository

    @Inject
    protected lateinit var activityRecognitionRepository: ActivityRecognitionRepository

<<<<<<< HEAD
    abstract val userModel: MutableState<RemoteUserModel>
=======
    val userModel get() = userUseCase.remoteUserModel

    val currentActivity get() = activityRecognitionRepository.currentActivity
>>>>>>> origin/master

    fun getCurrentLocation() = locationRepository.getCurrentLocation()

    fun requestLocationUpdates() = locationRepository.requestLocationUpdates()

    fun startLocationService(activity: Activity) =
        activityRecognitionRepository.startActivityRecognitionService(activity)

    fun stopLocationService(activity: Activity) =
        activityRecognitionRepository.stopActivityRecognitionService(activity)

<<<<<<< HEAD
    abstract val friendList: MutableList<RemoteUserModel>
=======
>>>>>>> origin/master
}