package com.find.android.core.domain.repository

import com.find.android.core.domain.model.SignUpModel
import com.find.android.core.util.event.ResponseState
import kotlinx.coroutines.flow.Flow

interface SignUpRepository {

    fun createUserWithEmailAndPassword(model: SignUpModel): Flow<ResponseState<String?>>
}