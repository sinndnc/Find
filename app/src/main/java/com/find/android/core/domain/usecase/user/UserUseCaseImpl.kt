package com.find.android.core.domain.usecase.user

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import com.find.android.core.domain.model.UserModel
import com.find.android.core.domain.repository.StorageRepository
import com.google.firebase.auth.FirebaseAuth
import javax.inject.Inject

class UserUseCaseImpl @Inject constructor(
    private val firebaseAuth: FirebaseAuth,
    private val storageRepository: StorageRepository,
) : UserUseCase {

    override val userUid: String
        get() = firebaseAuth.uid!!

    private val _userModel = mutableStateOf(UserModel())
    override val userModel: MutableState<UserModel> get() = _userModel

    override fun getUserInformation() {
        _userModel.value = storageRepository.getUserByUid(userUid)
    }
}