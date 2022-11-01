package com.find.android.core.domain.usecase.location.map

import android.location.Location
import androidx.compose.runtime.MutableState

interface LocationHelper {

    val currentLocation: MutableState<Location?>

    fun getCurrentLocation()

    fun requestLocationUpdates()

    fun stopLocationRequestUpdates()


}