package com.find.android.core.data.repository

import android.annotation.SuppressLint
import android.location.Location
import android.util.Log
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import com.find.android.core.data.local.room.entity.LocationModel
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

    private val _currentLocation: MutableState<LocationModel> = mutableStateOf(storageRepository.getUserLocation())
    override val currentLocation: MutableState<LocationModel> get() = _currentLocation

    override fun getLastKnownLocation() {
        locationService.getLastKnownLocation().onEach { responseState ->
            responseState.onLoading {

            }.onSuccess { location ->
                _currentLocation.value = location
                storageRepository.setUserLocation(location)
            }.onError {

            }
        }.launchIn(CoroutineScope(ioDispatcher))
    }

    override fun requestLocationUpdates() {
        locationService.requestLocationUpdates().onEach { responseState ->
            responseState.onLoading {
                Log.d("LocationTest", "requestLocationUpdates onLoading")
            }.onSuccess { location ->
                _currentLocation.value = location
                storageRepository.setUserLocation(location)
                Log.d("LocationTest", "requestLocationUpdates")
            }.onError {

            }
        }.launchIn(CoroutineScope(ioDispatcher))
    }

    override fun getCurrentLocation() {
        locationService.getCurrentLocation().onEach { responseState ->
            responseState.onLoading {
                Log.d("LocationTest", "getCurrentLocation onLoading")
            }.onSuccess { location ->
                _currentLocation.value = location
                storageRepository.setUserLocation(location)
                Log.d("LocationTest", "getCurrentLocation ")
            }.onError {

            }
        }.launchIn(CoroutineScope(ioDispatcher))
    }


}