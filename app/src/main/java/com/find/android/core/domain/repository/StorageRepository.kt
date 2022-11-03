package com.find.android.core.domain.repository

import com.find.android.core.data.local.room.entity.LocationModel
import com.find.android.core.data.local.room.entity.User
import com.find.android.core.domain.model.UserModel

interface StorageRepository {

    fun getUserByUid(uid: String): UserModel

    fun getUserLocation(): LocationModel

    fun insertUser(user: User)
}