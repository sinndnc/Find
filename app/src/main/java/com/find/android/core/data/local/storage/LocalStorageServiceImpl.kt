package com.find.android.core.data.local.storage

import com.find.android.core.data.local.room.dao.UserDao
import com.find.android.core.data.local.room.entity.LocalUserModel
import com.find.android.core.domain.local.storage.LocalStorageService
import com.find.android.core.domain.mapper.toRemoteUserModel
import com.find.android.core.domain.model.LocationModel
import com.find.android.core.domain.model.RemoteUserModel
import com.find.android.core.util.annotation.IoDispatcher
import com.find.android.core.util.event.ResponseState
import com.find.android.core.util.recognition.enums.DetectedActivityEnum
import com.google.firebase.auth.FirebaseAuth
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import javax.inject.Inject

class LocalStorageServiceImpl @Inject constructor(
    private val database: UserDao,
    private val firebaseAuth: FirebaseAuth,
    @IoDispatcher private val ioDispatcher: CoroutineDispatcher,
) : LocalStorageService {

    override fun insertUser(localUserModel: LocalUserModel) {
        CoroutineScope(ioDispatcher).launch {
            database.insertUser(localUserModel)
        }
    }

    override fun getUserById(uid: String): Flow<ResponseState<RemoteUserModel>> = flow {
        emit(ResponseState.Loading)
        val user = database.getUserByUid(uid).toRemoteUserModel()
        emit(ResponseState.Success(user))
    }.catch { exception ->
        emit(ResponseState.Error(exception))
    }.flowOn(ioDispatcher)

    override fun getUserActivityType(): DetectedActivityEnum =
        runBlocking(ioDispatcher) { database.getUserActivityType(firebaseAuth.uid!!) }

    override fun setUserActivityType(activityType: String) =
        runBlocking(ioDispatcher) { database.setUserActivityType(firebaseAuth.uid!!, activityType) }

    override fun setUserLocation(locationModel: LocationModel) =
        runBlocking(ioDispatcher) {
            database.setUserLocation(
                firebaseAuth.uid!!,
                locationModel.latitude,
                locationModel.longitude
            )
        }
}