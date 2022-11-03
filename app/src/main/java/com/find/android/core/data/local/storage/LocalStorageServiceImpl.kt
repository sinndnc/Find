package com.find.android.core.data.local.storage

import com.find.android.core.data.local.room.dao.UserDao
import com.find.android.core.data.local.room.entity.LocationModel
import com.find.android.core.data.local.room.entity.User
import com.find.android.core.domain.local.storage.LocalStorageService
import com.find.android.core.domain.mapper.toUserModule
import com.find.android.core.domain.model.UserModel
import com.find.android.core.util.annotation.IoDispatcher
import com.find.android.core.util.recognition.enums.DetectedActivityEnum
import com.google.firebase.auth.FirebaseAuth
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import javax.inject.Inject

class LocalStorageServiceImpl @Inject constructor(
    private val database: UserDao,
    private val firebaseAuth: FirebaseAuth,
    @IoDispatcher private val ioDispatcher: CoroutineDispatcher,
) : LocalStorageService {

    override fun insertUser(user: User) {
        CoroutineScope(ioDispatcher).launch {
            database.insertUser(user)
        }
    }

    override fun getUserById(uid: String): UserModel =
        runBlocking(ioDispatcher){database.getUserByUid(uid).toUserModule() }

    override fun getUserActivityType(): DetectedActivityEnum =
        runBlocking(ioDispatcher) { database.getUserActivityType(firebaseAuth.uid!!) }

    override fun setUserActivityType(activityType: String) =
        runBlocking(ioDispatcher) { database.setUserActivityType(firebaseAuth.uid!!, activityType) }

    override fun getUSerLocation(): LocationModel =
        runBlocking(ioDispatcher) { database.getUserLocation(firebaseAuth.uid!!) }
}