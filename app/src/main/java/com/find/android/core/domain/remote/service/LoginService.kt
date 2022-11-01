package com.find.android.core.domain.remote.service

import com.find.android.core.domain.model.LoginModel
import com.google.android.gms.tasks.Task
import com.google.firebase.auth.AuthResult

interface LoginService {

    fun loginWithEmailAndPassword(model : LoginModel): Task<AuthResult>
}