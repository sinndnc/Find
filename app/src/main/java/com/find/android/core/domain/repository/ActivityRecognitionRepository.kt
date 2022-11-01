package com.find.android.core.domain.repository

import androidx.compose.runtime.MutableState
import com.find.android.core.data.repository.DetectedActivityEnum
import com.google.android.gms.location.ActivityTransitionEvent

interface ActivityRecognitionRepository {

    val currentActivity: MutableState<DetectedActivityEnum>?

    fun setCurrentActivityType(activity: ActivityTransitionEvent)
}