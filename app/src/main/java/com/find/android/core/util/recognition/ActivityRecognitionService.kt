package com.find.android.core.util.recognition

import com.find.android.FindActivity
import com.google.android.gms.location.ActivityTransition

interface ActivityRecognitionService {

    fun getTransitions(): MutableList<ActivityTransition>

    fun requestActivityTransitionUpdates(activity: FindActivity)

    fun removeActivityTransitionUpdates(activity: FindActivity)
}