package com.find.android.feature.util.extension

import com.find.android.core.data.local.room.entity.LocationModel
import com.google.firebase.firestore.GeoPoint

fun GeoPoint.toLocationModel(): LocationModel = LocationModel(latitude,longitude)


fun LocationModel.toGeoPoint(): GeoPoint = GeoPoint(latitude, longitude)