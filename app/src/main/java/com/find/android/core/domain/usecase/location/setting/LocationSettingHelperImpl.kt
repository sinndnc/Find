package com.find.android.core.domain.usecase.location.setting

import com.find.android.core.util.annotation.IoDispatcher
import com.find.android.core.util.event.ResponseState
import com.google.android.gms.location.LocationRequest
import com.google.android.gms.location.LocationSettingsRequest
import com.google.android.gms.location.SettingsClient
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.tasks.await
import javax.inject.Inject

class LocationSettingHelperImpl @Inject constructor(
    private val settingsClient: SettingsClient,
    @IoDispatcher private val ioDispatcher: CoroutineDispatcher,
) : LocationSettingHelper {


    override fun checkLocationIsEnabled(): Flow<ResponseState<Boolean?>> = flow {
        emit(ResponseState.Loading)
        val locationSettingsRequest = LocationSettingsRequest.Builder().addLocationRequest(LocationRequest.create()).build()
        val task = settingsClient.checkLocationSettings(locationSettingsRequest).await()
        if (task != null) {
            emit(ResponseState.Success(task.locationSettingsStates?.isLocationUsable))
        }
    }.catch { exception ->
        emit(ResponseState.Error(exception))
    }.flowOn(ioDispatcher)

}