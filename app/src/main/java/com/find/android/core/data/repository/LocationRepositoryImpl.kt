package com.find.android.core.data.repository

import android.annotation.SuppressLint
import android.util.Log
import com.find.android.core.domain.repository.LocationRepository
import com.find.android.core.domain.repository.StorageRepository
import com.find.android.core.util.annotation.IoDispatcher
import com.find.android.core.util.location.LocationService
import com.google.android.gms.location.*
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.flow.*
import javax.inject.Inject

@SuppressLint("MissingPermission")
class LocationRepositoryImpl @Inject constructor(
    private val storageRepository: StorageRepository,
    private val locationService: LocationService,
    @IoDispatcher private val ioDispatcher: CoroutineDispatcher,
) : LocationRepository {

    override fun getLastKnownLocation() {
        locationService.getLastKnownLocation().onEach { responseState ->
            responseState.onLoading {

            }.onSuccess { location ->
                storageRepository.setUserLocation(location)
            }.onError {

            }
        }.launchIn(CoroutineScope(ioDispatcher))
    }

    override fun requestLocationUpdates() {
        locationService.requestLocationUpdates().onEach { responseState ->
            responseState
                .onLoading {
                    Log.d("LocationTest", "getCurrentLocation onLoading")
                }.onSuccess { location ->
                    storageRepository.setUserLocation(location)
                    Log.d("LocationTest", "requestLocationUpdates")
                }.onError {

                }
        }.launchIn(CoroutineScope(ioDispatcher))
    }

    override fun getCurrentLocation() {
        locationService.getCurrentLocation().onEach { responseState ->
            responseState
                .onLoading {
                    Log.d("LocationTest", "getCurrentLocation onLoading")
                }.onSuccess { location ->
                    storageRepository.setUserLocation(location)
                    Log.d("LocationTest", "getCurrentLocation: $location")
                }.onError {

                }
        }.launchIn(CoroutineScope(ioDispatcher))
    }


}