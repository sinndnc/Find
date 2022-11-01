package com.find.android.core.util.location

import android.location.Location
import com.find.android.core.util.event.ResponseState
import com.google.android.gms.location.LocationRequest
import kotlinx.coroutines.flow.Flow


interface LocationService {


    val locationRequest: LocationRequest

    fun getLastKnownLocation(): Flow<ResponseState<Location>>
    fun requestLocationUpdates(): Flow<ResponseState<Location>>
    fun getCurrentLocation(): Flow<ResponseState<Location>>
}