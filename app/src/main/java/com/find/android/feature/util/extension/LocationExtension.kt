package com.find.android.feature.util.extension

import com.find.android.core.data.repository.DetectedActivityEnum
import com.google.android.gms.location.ActivityTransition
import com.google.android.gms.location.DetectedActivity

fun Int.toTransitionType(): String {
    return when (this) {
        ActivityTransition.ACTIVITY_TRANSITION_ENTER -> "ENTER"
        ActivityTransition.ACTIVITY_TRANSITION_EXIT -> "EXIT"
        else -> "UNKNOWN"
    }
}


fun Int.toActivityEnum(): DetectedActivityEnum {
    return when (this) {
        DetectedActivity.IN_VEHICLE -> DetectedActivityEnum.IN_VEHICLE
        DetectedActivity.ON_BICYCLE -> DetectedActivityEnum.ON_BICYCLE
        DetectedActivity.ON_FOOT -> DetectedActivityEnum.ON_FOOT
        DetectedActivity.STILL -> DetectedActivityEnum.STILL
        DetectedActivity.TILTING -> DetectedActivityEnum.TILTING
        DetectedActivity.WALKING -> DetectedActivityEnum.WALKING
        DetectedActivity.RUNNING -> DetectedActivityEnum.RUNNING
        else -> DetectedActivityEnum.UNKNOWN
    }
}