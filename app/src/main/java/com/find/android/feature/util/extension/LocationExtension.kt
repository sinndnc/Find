package com.find.android.feature.util.extension

import android.location.Location
import com.find.android.R
import com.find.android.core.domain.model.LocationModel
import com.find.android.core.util.recognition.enums.DetectedActivityEnum
import com.google.android.gms.maps.model.LatLng

fun LocationModel.toLatLng(): LatLng = LatLng(latitude, longitude)

fun Location.toLocationModel(): LocationModel = LocationModel(latitude, longitude)

fun DetectedActivityEnum.detectModeIcon(): Int = when (this) {
    DetectedActivityEnum.STILL -> R.drawable.direction_still
    DetectedActivityEnum.WALKING -> R.drawable.directions_walk
    DetectedActivityEnum.RUNNING -> R.drawable.directions_run
    DetectedActivityEnum.ON_BICYCLE -> R.drawable.directions_bike
    DetectedActivityEnum.IN_VEHICLE -> R.drawable.directions_car
    else -> R.drawable.ic_launcher_foreground
}

fun String.detectModeIcon(): Int = when (this) {
    DetectedActivityEnum.STILL.name -> R.drawable.direction_still
    DetectedActivityEnum.WALKING.name -> R.drawable.directions_walk
    DetectedActivityEnum.RUNNING.name -> R.drawable.directions_run
    DetectedActivityEnum.ON_BICYCLE.name -> R.drawable.directions_bike
    DetectedActivityEnum.IN_VEHICLE.name -> R.drawable.directions_car
    else -> R.drawable.ic_launcher_foreground
}


fun String.toActivityType(): DetectedActivityEnum = when (this) {
    DetectedActivityEnum.STILL.name ->  DetectedActivityEnum.STILL
    DetectedActivityEnum.WALKING.name ->  DetectedActivityEnum.WALKING
    DetectedActivityEnum.RUNNING.name ->  DetectedActivityEnum.RUNNING
    DetectedActivityEnum.ON_BICYCLE.name ->  DetectedActivityEnum.ON_BICYCLE
    DetectedActivityEnum.IN_VEHICLE.name ->  DetectedActivityEnum.IN_VEHICLE
    else ->  DetectedActivityEnum.UNKNOWN
}
