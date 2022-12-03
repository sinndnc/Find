package com.find.android.core.domain.repository

import com.find.android.core.data.local.room.entity.LocalUserModel
import com.find.android.core.domain.model.LocationModel
import com.find.android.core.domain.model.RemoteUserModel
import com.find.android.core.util.event.ResponseState
import com.find.android.core.util.recognition.enums.DetectedActivityEnum
import kotlinx.coroutines.flow.Flow

interface StorageRepository {
    fun insertUser(localUserModel: LocalUserModel)

    fun getUserByUid(uid: String): RemoteUserModel

    fun getCurrentUser(): Flow<ResponseState<RemoteUserModel>>

    fun getUserRealTimeUpdate() : Flow<ResponseState<RemoteUserModel>>

    fun getUserFriendList(friendList: List<String>): List<RemoteUserModel>

    fun setUserLocation(locationModel: LocationModel)

    fun setUserActivityType(activityType: DetectedActivityEnum)

}