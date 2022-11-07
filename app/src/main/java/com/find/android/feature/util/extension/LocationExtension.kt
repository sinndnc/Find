package com.find.android.feature.util.extension

import android.location.Location
import com.find.android.R
import com.find.android.core.data.local.room.entity.LocationModel
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