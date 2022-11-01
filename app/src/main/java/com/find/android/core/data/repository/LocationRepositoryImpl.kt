package com.find.android.core.data.repository

import android.annotation.SuppressLint
import android.location.Location
import android.os.Looper
import android.util.Log
import com.find.android.core.domain.repository.LocationRepository
import com.find.android.core.util.annotation.IoDispatcher
import com.find.android.core.util.event.ResponseState
import com.google.android.gms.location.*
import com.google.android.gms.tasks.CancellationToken
import com.google.android.gms.tasks.CancellationTokenSource
import com.google.android.gms.tasks.OnTokenCanceledListener
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.channels.awaitClose
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.tasks.await
import javax.inject.Inject

@SuppressLint("MissingPermission")
class LocationRepositoryImpl @Inject constructor(
    @IoDispatcher private val ioDispatcher: CoroutineDispatcher,
    private val fusedLocationProviderClient: FusedLocationProviderClient,
) : LocationRepository {

    override val locationRequest: LocationRequest
        get() = LocationRequest.create().apply {
            priority = Priority.PRIORITY_HIGH_ACCURACY
            smallestDisplacement = 15F
            isWaitForAccurateLocation = true
            interval = 3000
            fastestInterval = 2000
        }

    override fun getLastKnownLocation(): Flow<ResponseState<Location>> = flow<ResponseState<Location>> {
        emit(ResponseState.Loading)
        val lastLocation = fusedLocationProviderClient.lastLocation.await()
        emit(ResponseState.Success(lastLocation))
    }.catch {
        Log.d("LocationTest", it.cause.toString())
        emit(ResponseState.Error(it.cause))
    }.flowOn(ioDispatcher)


    override fun getCurrentLocation(): Flow<ResponseState<Location>> = flow {
        emit(ResponseState.Loading)
        val task =
            fusedLocationProviderClient.getCurrentLocation(Priority.PRIORITY_HIGH_ACCURACY, CancellationCallback()).await()
        if (task != null) {
            emit(ResponseState.Success(task))
        }
    }.catch { exception ->
        emit(ResponseState.Error(exception))
    }.flowOn(ioDispatcher)


    override fun requestLocationUpdates(): Flow<ResponseState<Location>> = callbackFlow {
        trySend(ResponseState.Loading)
        val callBack = object : LocationCallback() {
            override fun onLocationResult(locationResult: LocationResult) {
                locationResult.lastLocation?.let { trySend(ResponseState.Success(it)) }
                super.onLocationResult(locationResult)
            }
        }
        fusedLocationProviderClient.requestLocationUpdates(locationRequest, callBack, Looper.getMainLooper())
        awaitClose { fusedLocationProviderClient.removeLocationUpdates(callBack) }
    }.catch {
        Log.d("LocationTest", it.cause.toString())
        emit(ResponseState.Error(it.cause))
    }.flowOn(ioDispatcher)


    private inner class CancellationCallback : CancellationToken() {
        override fun onCanceledRequested(p0: OnTokenCanceledListener): CancellationToken {
            return CancellationTokenSource().token
        }

        override fun isCancellationRequested(): Boolean {
            return false
        }
    }


}