package com.find.android.core.data.remote.service

import com.find.android.core.domain.model.LoginModel
import com.find.android.core.domain.remote.service.LoginService
import com.google.android.gms.tasks.Task
import com.google.firebase.auth.AuthResult
import com.google.firebase.auth.FirebaseAuth
import javax.inject.Inject

class LoginServiceImpl @Inject constructor(
    private val auth: FirebaseAuth
) : LoginService {

    override fun loginWithEmailAndPassword(model: LoginModel): Task<AuthResult> =
        auth.signInWithEmailAndPassword(model.email, model.password)


}