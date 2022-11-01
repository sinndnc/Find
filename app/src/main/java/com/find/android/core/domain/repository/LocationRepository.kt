package com.find.android.core.domain.repository

import android.location.Location
import androidx.compose.runtime.MutableState

interface LocationRepository {

    val currentLocation: MutableState<Location>

    fun getLastKnownLocation()

    fun requestLocationUpdates()

    fun getCurrentLocation()

}