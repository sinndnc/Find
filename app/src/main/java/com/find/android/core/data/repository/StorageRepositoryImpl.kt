package com.find.android.core.data.repository

import com.find.android.core.data.local.room.entity.LocationModel
import com.find.android.core.data.local.room.entity.User
import com.find.android.core.domain.local.storage.LocalStorageService
import com.find.android.core.domain.mapper.toUserModule
import com.find.android.core.domain.model.UserModel
import com.find.android.core.domain.remote.storage.RemoteStorageService
import com.find.android.core.domain.repository.StorageRepository
import com.find.android.core.util.annotation.GoogleApi
import com.find.android.core.util.extension.checkIsAvailable
import javax.inject.Inject

class StorageRepositoryImpl @Inject constructor(
    @GoogleApi private val googleApi: Int,
    private val localStorageService: LocalStorageService,
    private val remoteStorageService: RemoteStorageService,
) : StorageRepository {

    override fun insertUser(user: User) = if (googleApi.checkIsAvailable())
        remoteStorageService.insertUser(user.toUserModule()) else localStorageService.insertUser(user)

    override fun getUserByUid(uid: String): UserModel = if (googleApi.checkIsAvailable())
        remoteStorageService.getUserByUid(uid) else localStorageService.getUserById(uid)

    override fun getUserLocation(): LocationModel = if (googleApi.checkIsAvailable())
        remoteStorageService.getUserLocation() else localStorageService.getUserLocation()

    override fun setUserLocation(locationModel: LocationModel) { if (googleApi.checkIsAvailable())
        remoteStorageService.setUserLocation(locationModel) else localStorageService.setUserLocation(locationModel)
    }

}