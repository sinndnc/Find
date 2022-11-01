package com.find.android.core.domain.usecase.user

import android.util.Log
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import com.find.android.core.domain.model.UserModel
import com.find.android.core.domain.repository.StorageRepository
import com.find.android.core.util.annotation.IoDispatcher
import com.google.firebase.auth.FirebaseAuth
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

class UserUseCaseImpl @Inject constructor(
    private val firebaseAuth: FirebaseAuth,
    private val storageRepository: StorageRepository,
    @IoDispatcher private val ioDispatcher: CoroutineDispatcher,
) : UserUseCase {

    override val userUid: String
        get() = firebaseAuth.uid!!

    private val _userModel = mutableStateOf(UserModel())
    override val userModel: MutableState<UserModel> get() = _userModel

    override fun getUserInformation() {
        storageRepository.getUserByUid(userUid).onEach { result ->
            result.onLoading {

            }.onSuccess {
                Log.d("UserTest",it.toString() + "NULL")
                _userModel.value = it
            }.onError {

            }
        }.launchIn(CoroutineScope(ioDispatcher))
    }
}