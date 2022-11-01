package com.find.android.core.domain.remote.storage

import com.find.android.core.domain.model.UserModel
import com.find.android.core.util.event.ResponseState
import kotlinx.coroutines.flow.Flow

interface RemoteStorageService {

    fun getUserByUid(uid: String): Flow<ResponseState<UserModel>>

    fun insertUser(user: UserModel)

    suspend fun getUserImage(uid: String): ByteArray
}