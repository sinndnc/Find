package com.find.android.core.domain.local.storage

import com.find.android.core.data.local.room.entity.LocationModel
import com.find.android.core.data.local.room.entity.User
import com.find.android.core.domain.model.UserModel
import com.find.android.core.util.event.ResponseState
import com.find.android.core.util.recognition.enums.DetectedActivityEnum
import kotlinx.coroutines.flow.Flow

interface LocalStorageService {

    fun getUserById(uid: String): UserModel

    fun getUserActivityType(): DetectedActivityEnum

    fun setUserActivityType(activityType: String)

    fun getUserLocation(): LocationModel

    fun insertUser(user: User)
    fun setUserLocation(locationModel: LocationModel)
}