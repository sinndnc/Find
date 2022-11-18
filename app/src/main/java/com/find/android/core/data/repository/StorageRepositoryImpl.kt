package com.find.android.core.data.repository

import android.net.ConnectivityManager
import com.find.android.core.data.local.room.entity.LocalUserModel
import com.find.android.core.domain.local.storage.LocalStorageService
import com.find.android.core.domain.mapper.toRemoteUserModel
import com.find.android.core.domain.model.LocationModel
import com.find.android.core.domain.model.RemoteUserModel
import com.find.android.core.domain.remote.storage.RemoteStorageService
import com.find.android.core.domain.repository.StorageRepository
import com.find.android.core.util.event.ResponseState
import com.find.android.feature.util.extension.hasInternet
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class StorageRepositoryImpl @Inject constructor(
    private val connectivityManager: ConnectivityManager,
    private val localStorageService: LocalStorageService,
    private val remoteStorageService: RemoteStorageService,
) : StorageRepository {

    override fun insertUser(localUserModel: LocalUserModel) = if (connectivityManager.hasInternet())
        remoteStorageService.insertUser(localUserModel.toRemoteUserModel()) else localStorageService.insertUser(localUserModel)

    override fun getUserByUid(uid: String): Flow<ResponseState<RemoteUserModel>> = if (connectivityManager.hasInternet())
        remoteStorageService.getUserByUid(uid) else localStorageService.getUserById(uid)

    override fun setUserLocation(locationModel: LocationModel) = if (connectivityManager.hasInternet())
        remoteStorageService.setUserLocation(locationModel) else localStorageService.setUserLocation(locationModel)
}