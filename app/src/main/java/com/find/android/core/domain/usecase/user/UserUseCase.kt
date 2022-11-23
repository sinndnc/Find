package com.find.android.core.domain.usecase.user

import androidx.compose.runtime.MutableState
import com.find.android.core.domain.model.UserModel

interface UserUseCase {

    val userUid: String

    val userModel: MutableState<UserModel>

    fun getUserInformation()

}