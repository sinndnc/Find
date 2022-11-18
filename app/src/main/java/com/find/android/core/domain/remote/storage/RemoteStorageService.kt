package com.find.android.core.domain.remote.storage

import com.find.android.core.domain.model.LocationModel
import com.find.android.core.domain.model.RemoteUserModel
import com.find.android.core.util.event.ResponseState
import kotlinx.coroutines.flow.Flow

interface RemoteStorageService {

    fun getUserByUid(uid: String): Flow<ResponseState<RemoteUserModel>>

    fun insertUser(user: RemoteUserModel)

    fun getUserImage(uid: String): ByteArray

    fun setUserLocation(locationModel: LocationModel)
}