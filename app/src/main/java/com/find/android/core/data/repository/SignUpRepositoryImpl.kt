package com.find.android.core.data.repository

import com.find.android.core.domain.model.SignUpModel
import com.find.android.core.domain.remote.service.SignUpService
import com.find.android.core.domain.repository.SignUpRepository
import com.find.android.core.util.annotation.IoDispatcher
import com.find.android.core.util.event.ResponseState
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.tasks.await
import javax.inject.Inject

class SignUpRepositoryImpl @Inject constructor(
    private val signUpService: SignUpService,
    @IoDispatcher private val dispatcher: CoroutineDispatcher
) : SignUpRepository {

    override fun createUserWithEmailAndPassword(model: SignUpModel): Flow<ResponseState<String?>> =
        flow {
            emit(ResponseState.Loading)
            val response = signUpService.createUserWithEmailAndPassword(model).await()
            if (response.user != null) {
                emit(ResponseState.Success(response.user!!.uid))
            }
        }.catch { error ->
            emit(ResponseState.Error(error))
        }.flowOn(dispatcher)
}