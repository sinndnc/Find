package com.find.android.core.domain.repository

import androidx.compose.runtime.MutableState
import com.find.android.core.data.local.room.entity.LocationModel

interface LocationRepository {

    val currentLocation: MutableState<LocationModel>

    fun getLastKnownLocation()

    fun requestLocationUpdates()

    fun getCurrentLocation()

}