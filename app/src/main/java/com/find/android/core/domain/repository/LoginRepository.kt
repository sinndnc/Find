package com.find.android.core.domain.repository

import com.find.android.core.domain.model.LoginModel
import com.find.android.core.util.event.ResponseState
import kotlinx.coroutines.flow.Flow

interface LoginRepository {

    fun loginWithEmailAndPassword(model: LoginModel): Flow<ResponseState<String?>>
}