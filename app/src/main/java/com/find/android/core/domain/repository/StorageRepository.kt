package com.find.android.core.domain.repository

import com.find.android.core.data.local.room.entity.User
import com.find.android.core.domain.model.UserModel
import com.find.android.core.util.event.ResponseState
import kotlinx.coroutines.flow.Flow

interface StorageRepository {

    fun getUserByUid(uid: String): Flow<ResponseState<UserModel>>

    fun insertUser(user: User)

}