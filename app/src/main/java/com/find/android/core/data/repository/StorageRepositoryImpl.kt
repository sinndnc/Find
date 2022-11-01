package com.find.android.core.data.repository

import com.find.android.core.data.local.room.entity.User
import com.find.android.core.domain.local.storage.LocalStorageService
import com.find.android.core.domain.mapper.toUserModule
import com.find.android.core.domain.model.UserModel
import com.find.android.core.domain.remote.storage.RemoteStorageService
import com.find.android.core.domain.repository.StorageRepository
import com.find.android.core.util.annotation.GoogleApi
import com.find.android.core.util.event.ResponseState
import com.find.android.core.util.extension.checkIsAvailable
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class StorageRepositoryImpl @Inject constructor(
    @GoogleApi private val googleApi: Int,
    private val localStorageService: LocalStorageService,
    private val remoteStorageService: RemoteStorageService,
) : StorageRepository {

    //Todo(burda bi sorun var ama bakıcaz apiyle ilgili)
    override fun getUserByUid(uid: String): Flow<ResponseState<UserModel>> =
        if (googleApi.checkIsAvailable()) {
            remoteStorageService.getUserByUid(uid)
        } else {
            localStorageService.getUserById(uid)
        }

    override fun insertUser(user: User) {
        if (googleApi.checkIsAvailable()) {
            remoteStorageService.insertUser(user.toUserModule())
        } else {
            localStorageService.insertUser(user)
        }
    }



}