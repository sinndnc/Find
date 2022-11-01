package com.find.android.core.data.repository

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import com.find.android.core.domain.local.storage.LocalStorageService
import com.find.android.core.domain.repository.ActivityRecognitionRepository
import com.find.android.feature.util.extension.toActivityEnum
import com.google.android.gms.location.ActivityTransitionEvent
import javax.inject.Inject

enum class DetectedActivityEnum { IN_VEHICLE, ON_BICYCLE, ON_FOOT, STILL, UNKNOWN, TILTING, ERROR, WALKING, RUNNING }

class ActivityRecognitionRepositoryImpl @Inject constructor(
    private val localStorageService: LocalStorageService,
) : ActivityRecognitionRepository {

    override val currentActivity: MutableState<DetectedActivityEnum>
        get() = mutableStateOf(localStorageService.getUserActivityType())

    override fun setCurrentActivityType(activity: ActivityTransitionEvent) {
        val currentActivityType = activity.activityType.toActivityEnum()
        localStorageService.setUserActivityType(currentActivityType.name)
        currentActivity.value = currentActivityType
    }

}