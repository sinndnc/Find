package com.find.android.core.domain.repository

import android.app.Activity
import com.google.android.gms.location.ActivityTransitionEvent

interface ActivityRecognitionRepository {

    fun setCurrentActivityType(activity: ActivityTransitionEvent)

    fun startActivityRecognitionService(activity: Activity)

    fun stopActivityRecognitionService(activity: Activity)
}