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
import com.find.android.core.util.recognition.enums.DetectedActivityEnum
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

    override fun getUserFriendList(friendList: List<String>): List<RemoteUserModel> =
        remoteStorageService.getUserFriendList(friendList)

    override fun getUserByUid(uid: String): RemoteUserModel = if (connectivityManager.hasInternet())
        remoteStorageService.getUserByUid(uid) else localStorageService.getUserByUid(uid)

    override fun getCurrentUser(): Flow<ResponseState<RemoteUserModel>> = if (connectivityManager.hasInternet())
        remoteStorageService.getCurrentUser() else localStorageService.getCurrentUser()

    override fun setUserLocation(locationModel: LocationModel) {
        remoteStorageService.setUserLocation(locationModel)
        localStorageService.setUserLocation(locationModel)
    }

    override fun setUserActivityType(activityType: DetectedActivityEnum) {
        remoteStorageService.setUserActivityType(activityType)
        localStorageService.setUserActivityType(activityType)
    }
}