package com.find.android.core.domain.usecase.location.map

import android.location.Location
import android.util.Log
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import com.find.android.core.domain.repository.LocationRepository
import com.find.android.core.util.annotation.IoDispatcher
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

class LocationHelperImpl @Inject constructor(
    private val locationRepository: LocationRepository,
    @IoDispatcher private val ioDispatcher: CoroutineDispatcher,
) : LocationHelper {

    private val _currentLocation: MutableState<Location?> = mutableStateOf(null)
    override val currentLocation: MutableState<Location?> get() = _currentLocation

    override fun getCurrentLocation() {
        locationRepository.getCurrentLocation().onEach { result ->
            result.onLoading {
                Log.d("LocationTest", currentLocation.value.toString() + "Loading")
            }.onSuccess { newLocation ->
                _currentLocation.value = newLocation
                Log.d("LocationTest", currentLocation.value.toString() + "Location Helper")
            }.onError { exception ->
                Log.d("LocationTest", "$exception Location Helper Error")
            }
        }.launchIn(CoroutineScope(ioDispatcher))
    }

    override fun requestLocationUpdates() {
        locationRepository.requestLocationUpdates().onEach { result ->
            result.onLoading {
                Log.d("LocationTest", currentLocation.value.toString() + "Loading")
            }.onSuccess { newLocation ->
                _currentLocation.value = newLocation
                Log.d("LocationTest", currentLocation.value.toString() + "startLocationRequestUpdates")
            }.onError {
                Log.d("LocationTest", it.toString() + "startLocationRequestUpdates ")
            }
        }.launchIn(CoroutineScope(ioDispatcher))
    }

    override fun stopLocationRequestUpdates() {
        TODO("Not yet implemented")
    }


}