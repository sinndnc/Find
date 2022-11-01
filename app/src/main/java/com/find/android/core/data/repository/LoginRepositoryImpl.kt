package com.find.android.core.data.repository

import com.find.android.core.domain.model.LoginModel
import com.find.android.core.domain.remote.service.LoginService
import com.find.android.core.domain.repository.LoginRepository
import com.find.android.core.util.annotation.IoDispatcher
import com.find.android.core.util.event.ResponseState
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.tasks.await
import javax.inject.Inject

class LoginRepositoryImpl @Inject constructor(
    private val loginService: LoginService,
    @IoDispatcher private val dispatcher: CoroutineDispatcher
) : LoginRepository {

    override fun loginWithEmailAndPassword(model: LoginModel): Flow<ResponseState<String?>> =
        flow {
            emit(ResponseState.Loading)
            val response = loginService.loginWithEmailAndPassword(model).await()
            if (response.user != null) {
                emit(ResponseState.Success(response.user!!.uid))
            }
        }.catch { error ->
            emit(ResponseState.Error(error))
        }.flowOn(dispatcher)


}