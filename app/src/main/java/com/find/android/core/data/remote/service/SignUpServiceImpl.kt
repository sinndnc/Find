package com.find.android.core.data.remote.service

import com.find.android.core.domain.model.SignUpModel
import com.find.android.core.domain.remote.service.SignUpService
import com.google.android.gms.tasks.Task
import com.google.firebase.auth.AuthResult
import com.google.firebase.auth.FirebaseAuth
import javax.inject.Inject

class SignUpServiceImpl @Inject constructor(
    private val firebaseAuth: FirebaseAuth
) : SignUpService {

    override fun createUserWithEmailAndPassword(signUpModel: SignUpModel): Task<AuthResult> =
        firebaseAuth.createUserWithEmailAndPassword(signUpModel.email,signUpModel.password)

}