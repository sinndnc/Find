package com.find.android.core.data.local.storage

import com.find.android.core.data.local.room.dao.UserDao
import com.find.android.core.data.local.room.entity.User
import com.find.android.core.data.repository.DetectedActivityEnum
import com.find.android.core.domain.local.storage.LocalStorageService
import com.find.android.core.domain.mapper.toUserModule
import com.find.android.core.domain.model.UserModel
import com.find.android.core.util.annotation.IoDispatcher
import com.find.android.core.util.event.ResponseState
import com.google.firebase.auth.FirebaseAuth
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import javax.inject.Inject

class LocalStorageServiceImpl @Inject constructor(
    @IoDispatcher private val ioDispatcher: CoroutineDispatcher,
    private val firebaseAuth: FirebaseAuth,
    private val database: UserDao,
) : LocalStorageService {

    //Todo(düzeltcem ama acelesi yok)
    override fun getUserById(uid: String): Flow<ResponseState<UserModel>> = flow {
        emit(ResponseState.Loading)
        emit(ResponseState.Success(database.getUserByUid(uid).toUserModule()))
    }

    override fun insertUser(user: User) {
        CoroutineScope(ioDispatcher).launch {
            database.insertUser(user)
        }
    }

    override fun getUserActivityType(): DetectedActivityEnum =
        runBlocking(ioDispatcher) { database.getUserActivityType(firebaseAuth.uid!!) }


    override fun setUserActivityType(activityType: String) =
        runBlocking(ioDispatcher) { database.setUserActivityType(firebaseAuth.uid!!, activityType) }


}