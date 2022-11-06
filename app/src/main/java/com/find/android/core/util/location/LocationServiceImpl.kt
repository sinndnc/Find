package com.find.android.core.util.location

import android.annotation.SuppressLint
import android.location.Location
import android.os.Looper
import android.util.Log
import com.find.android.core.data.local.room.entity.LocationModel
import com.find.android.core.domain.repository.ActivityRecognitionRepository
import com.find.android.core.util.annotation.IoDispatcher
import com.find.android.core.util.event.ResponseState
import com.find.android.core.util.recognition.enums.DetectedActivityEnum
import com.find.android.feature.util.extension.toLocationModel
import com.google.android.gms.location.*
import com.google.android.gms.tasks.CancellationToken
import com.google.android.gms.tasks.CancellationTokenSource
import com.google.android.gms.tasks.OnTokenCanceledListener
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.channels.awaitClose
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.tasks.await
import javax.inject.Inject

@SuppressLint("MissingPermission")
class LocationServiceImpl @Inject constructor(
    @IoDispatcher private val ioDispatcher: CoroutineDispatcher,
    private val fusedLocationProviderClient: FusedLocationProviderClient,
    private val activityRecognitionRepository: ActivityRecognitionRepository
) : LocationService {

    override val locationRequest: LocationRequest
        get() = LocationRequest.create().apply {
            priority = Priority.PRIORITY_HIGH_ACCURACY
            smallestDisplacement = 15F
            isWaitForAccurateLocation = true
            interval = 3000
            fastestInterval = 2000
        }

    override fun getLastKnownLocation(): Flow<ResponseState<LocationModel>> = flow {
        emit(ResponseState.Loading)
        val lastLocation = fusedLocationProviderClient.lastLocation.await()
        if (lastLocation != null) emit(ResponseState.Success(lastLocation.toLocationModel()))
    }.catch {
        Log.d("LocationTest", it.cause.toString())
        emit(ResponseState.Error(it.cause))
    }.flowOn(ioDispatcher)


    override fun getCurrentLocation(): Flow<ResponseState<LocationModel>> = flow {
        emit(ResponseState.Loading)
        val location = fusedLocationProviderClient.getCurrentLocation(Priority.PRIORITY_HIGH_ACCURACY, CancellationCallback()).await()
        if (location != null) emit(ResponseState.Success(location.toLocationModel()))
    }.catch { exception ->
        emit(ResponseState.Error(exception))
    }.flowOn(ioDispatcher)


    override fun requestLocationUpdates(): Flow<ResponseState<LocationModel>> = callbackFlow {
        trySend(ResponseState.Loading)
        val callBack = object : LocationCallback() {
            override fun onLocationResult(locationResult: LocationResult) {
                if (activityRecognitionRepository.currentActivity.value == DetectedActivityEnum.STILL)
                    fusedLocationProviderClient.removeLocationUpdates(this)
                else
                    locationResult.lastLocation?.let { trySend(ResponseState.Success(it.toLocationModel())) }
                super.onLocationResult(locationResult)
            }
        }
        fusedLocationProviderClient.requestLocationUpdates(locationRequest, callBack, Looper.getMainLooper())
        awaitClose { fusedLocationProviderClient.removeLocationUpdates(callBack) }
    }.catch {
        Log.d("LocationTest", "catch " + it.cause.toString())
        emit(ResponseState.Error(it.cause))
    }.flowOn(ioDispatcher)

    override fun removeRequestLocationUpdates(callback: LocationCallback) {
        Log.d("LocationTest", "removeRequestLocationUpdates")
        runBlocking(ioDispatcher) { fusedLocationProviderClient.removeLocationUpdates(callback).await() }
    }

    private inner class CancellationCallback : CancellationToken() {
        override fun onCanceledRequested(p0: OnTokenCanceledListener): CancellationToken {
            return CancellationTokenSource().token
        }

        override fun isCancellationRequested(): Boolean {
            return false
        }
    }

}