package com.find.android.feature.util.extension

import android.location.Location
import com.find.android.core.data.local.room.entity.LocationModel
import com.google.android.gms.maps.model.LatLng


fun LocationModel.toLatLng(): LatLng = LatLng(latitude,longitude)

fun Location.toLocationModel(): LocationModel = LocationModel(latitude,longitude)