package com.find.android.core.domain.usecase.user

import android.util.Log
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.snapshots.SnapshotStateList
import com.find.android.core.data.local.room.dao.UserDao
import com.find.android.core.domain.mapper.toRemoteUserModel
import com.find.android.core.domain.model.RemoteUserModel
import com.find.android.core.domain.repository.StorageRepository
import com.find.android.core.util.annotation.IoCoroutineScope
import com.find.android.core.util.annotation.IoDispatcher
import com.google.firebase.auth.FirebaseAuth
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.runBlocking
import javax.inject.Inject

class UserUseCaseImpl @Inject constructor(
    database: UserDao,
    private val firebaseAuth: FirebaseAuth,
    private val storageRepository: StorageRepository,
    @IoDispatcher private val ioDispatcher: CoroutineDispatcher,
    @IoCoroutineScope private val coroutineScope: CoroutineScope,
) : UserUseCase {

    private val currentUser = runBlocking(ioDispatcher) { database.getUserByUid(firebaseAuth.uid!!).toRemoteUserModel() }
    private val _userModel: MutableState<RemoteUserModel> = mutableStateOf(currentUser)
    override val userModel: MutableState<RemoteUserModel> = _userModel

    private var _friendList: SnapshotStateList<RemoteUserModel> = mutableStateListOf()
    override var friendList: SnapshotStateList<RemoteUserModel> = _friendList

    init {
        getUserRealTimeUpdate()
    }

    override fun getUserInformation() {
        storageRepository.getCurrentUser().onEach { responseState ->
            responseState.onLoading {

            }.onSuccess { user ->
                _userModel.value = user
                _friendList.addAll(storageRepository.getUserFriendList(user.friends))
            }.onError {
                Log.d("UserTest", "getUserInformation $it")
            }
        }.launchIn(coroutineScope)
    }


    private fun getUserRealTimeUpdate() {
        storageRepository.getUserRealTimeUpdate().onEach { responseState ->
            responseState.onLoading {

            }.onSuccess { currentUser ->
                _userModel.value = currentUser
                Log.d("UserTest", "getUserInformation $currentUser")
            }.onError {
                Log.d("UserTest", "getUserInformation $it")
            }
        }.launchIn(coroutineScope)
    }
}