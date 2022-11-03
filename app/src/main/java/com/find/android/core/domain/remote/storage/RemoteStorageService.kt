package com.find.android.core.domain.remote.storage

import com.find.android.core.data.local.room.entity.LocationModel
import com.find.android.core.domain.model.UserModel

interface RemoteStorageService {

    fun getUserByUid(uid: String): UserModel

    fun insertUser(user: UserModel)

    fun getUserLocation():LocationModel

    fun getUserImage(uid: String): ByteArray
}