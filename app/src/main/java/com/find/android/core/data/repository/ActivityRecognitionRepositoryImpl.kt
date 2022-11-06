package com.find.android.core.data.repository


import android.app.Activity
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import com.find.android.FindActivity
import com.find.android.core.domain.local.storage.LocalStorageService
import com.find.android.core.domain.repository.ActivityRecognitionRepository
import com.find.android.core.util.recognition.ActivityRecognitionService
import com.find.android.core.util.recognition.enums.DetectedActivityEnum
import com.find.android.feature.util.extension.toActivityEnum
import com.google.android.gms.location.ActivityTransitionEvent
import javax.inject.Inject

class ActivityRecognitionRepositoryImpl @Inject constructor(
    private val localStorageService: LocalStorageService,
    private val activityRecognitionService: ActivityRecognitionService
) : ActivityRecognitionRepository {

    private val _currentActivity: MutableState<DetectedActivityEnum> = mutableStateOf(localStorageService.getUserActivityType())
    override val currentActivity: MutableState<DetectedActivityEnum> get() = _currentActivity

    override fun setCurrentActivityType(activity: ActivityTransitionEvent) {
        val currentActivityType = activity.activityType.toActivityEnum()
        localStorageService.setUserActivityType(currentActivityType.name)
        _currentActivity.value = currentActivityType
    }

    override fun startActivityRecognitionService(activity: Activity) =
        activityRecognitionService.requestActivityTransitionUpdates(activity as FindActivity)

    override fun stopActivityRecognitionService(activity: Activity) =
        activityRecognitionService.removeActivityTransitionUpdates(activity as FindActivity)

}