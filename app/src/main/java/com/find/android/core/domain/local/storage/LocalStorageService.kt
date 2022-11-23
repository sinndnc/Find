package com.find.android.core.domain.local.storage

import com.find.android.core.data.local.room.entity.LocalUserModel
import com.find.android.core.domain.model.LocationModel
import com.find.android.core.domain.model.RemoteUserModel
import com.find.android.core.util.event.ResponseState
import com.find.android.core.util.recognition.enums.DetectedActivityEnum
import kotlinx.coroutines.flow.Flow

interface LocalStorageService {

    fun getUserById(uid: String): Flow<ResponseState<RemoteUserModel>>

    fun getUserActivityType(): DetectedActivityEnum

    fun setUserActivityType(activityType: String)

    fun insertUser(localUserModel: LocalUserModel)

    fun setUserLocation(locationModel: LocationModel)

}