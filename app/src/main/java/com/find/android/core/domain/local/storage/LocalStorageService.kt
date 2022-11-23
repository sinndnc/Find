package com.find.android.core.domain.local.storage

import com.find.android.core.data.local.room.entity.LocalUserModel
import com.find.android.core.domain.model.LocationModel
import com.find.android.core.domain.model.RemoteUserModel
import com.find.android.core.util.event.ResponseState
import com.find.android.core.util.recognition.enums.DetectedActivityEnum
import kotlinx.coroutines.flow.Flow

interface LocalStorageService {

    fun getUserByUid(uid: String): RemoteUserModel

    fun getUserActivityType(): DetectedActivityEnum

    fun setUserActivityType(activityType: DetectedActivityEnum)

    fun insertUser(localUserModel: LocalUserModel)

    fun setUserLocation(locationModel: LocationModel)

    fun getCurrentUser(): Flow<ResponseState<RemoteUserModel>>

}