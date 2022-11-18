package com.find.android.core.domain.repository


interface LocationRepository {

    fun getLastKnownLocation()

    fun requestLocationUpdates()

    fun getCurrentLocation()

}