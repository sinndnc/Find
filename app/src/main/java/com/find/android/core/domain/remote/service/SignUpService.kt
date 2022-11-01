package com.find.android.core.domain.remote.service

import com.find.android.core.domain.model.SignUpModel
import com.google.android.gms.tasks.Task
import com.google.firebase.auth.AuthResult

interface SignUpService {

    fun createUserWithEmailAndPassword(signUpModel: SignUpModel): Task<AuthResult>
}