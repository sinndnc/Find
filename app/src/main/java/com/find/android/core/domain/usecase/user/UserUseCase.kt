package com.find.android.core.domain.usecase.user

import androidx.compose.runtime.MutableState
import com.find.android.core.domain.model.RemoteUserModel

interface UserUseCase {

    val remoteUserModel: MutableState<RemoteUserModel>

    fun getUserInformation()
}