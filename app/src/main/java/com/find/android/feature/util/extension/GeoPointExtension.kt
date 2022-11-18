package com.find.android.feature.util.extension

import com.find.android.core.domain.model.LocationModel
import com.google.android.gms.maps.model.LatLng
import com.google.firebase.firestore.GeoPoint

fun GeoPoint.toLocationModel(): LocationModel = LocationModel(latitude,longitude)

fun GeoPoint.toLatLng() : LatLng  = LatLng(latitude,longitude)


fun LocationModel.toGeoPoint(): GeoPoint = GeoPoint(latitude, longitude)