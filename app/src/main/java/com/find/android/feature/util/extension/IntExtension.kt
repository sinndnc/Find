package com.find.android.feature.util.extension

import com.find.android.core.util.recognition.enums.DetectedActivityEnum
import com.google.android.gms.location.DetectedActivity


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