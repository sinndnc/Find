package com.find.android.core.domain.remote.storage

import com.find.android.core.domain.model.LocationModel
import com.find.android.core.domain.model.RemoteUserModel
import com.find.android.core.util.event.ResponseState
import com.find.android.core.util.recognition.enums.DetectedActivityEnum
import kotlinx.coroutines.flow.Flow

interface RemoteStorageService {

    fun getUserByUid(uid: String): RemoteUserModel

    fun getCurrentUser(): Flow<ResponseState<RemoteUserModel>>

    fun getUserRealTimeUpdate(): Flow<ResponseState<RemoteUserModel>>

    fun insertUser(user: RemoteUserModel)

    fun getUserImage(uid: String): ByteArray

    fun setUserLocation(locationModel: LocationModel)

    fun setUserActivityType(activityType: DetectedActivityEnum)

    fun getUserFriendList(friendList: List<String>): List<RemoteUserModel>
}