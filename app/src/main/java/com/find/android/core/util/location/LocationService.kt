package com.find.android.core.util.location

import com.find.android.core.domain.model.LocationModel
import com.find.android.core.util.event.ResponseState
import com.google.android.gms.location.LocationCallback
import com.google.android.gms.location.LocationRequest
import kotlinx.coroutines.flow.Flow

interface LocationService {

    val locationRequest: LocationRequest

    fun getLastKnownLocation(): Flow<ResponseState<LocationModel>>

    fun requestLocationUpdates(): Flow<ResponseState<LocationModel>>

    fun getCurrentLocation(): Flow<ResponseState<LocationModel>>

    fun removeRequestLocationUpdates(callback: LocationCallback)
}