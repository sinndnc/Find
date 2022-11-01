package com.find.android.core.domain.local.storage

import com.find.android.core.data.local.room.entity.User
import com.find.android.core.data.repository.DetectedActivityEnum
import com.find.android.core.domain.model.UserModel
import com.find.android.core.util.event.ResponseState
import kotlinx.coroutines.flow.Flow

interface LocalStorageService {

    fun getUserById(uid: String): Flow<ResponseState<UserModel>>

    fun getUserActivityType(): DetectedActivityEnum

    fun setUserActivityType(activityType: String)

    fun insertUser(user: User)
}