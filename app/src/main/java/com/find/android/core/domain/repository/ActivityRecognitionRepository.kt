package com.find.android.core.domain.repository

import android.app.Activity
import androidx.compose.runtime.MutableState
import com.find.android.core.util.recognition.enum.DetectedActivityEnum
import com.google.android.gms.location.ActivityTransitionEvent

interface ActivityRecognitionRepository {

    val currentActivity: MutableState<DetectedActivityEnum>?

    fun setCurrentActivityType(activity: ActivityTransitionEvent)

    fun startActivityRecognitionService(activity: Activity)

    fun stopActivityRecognitionService(activity: Activity)
}