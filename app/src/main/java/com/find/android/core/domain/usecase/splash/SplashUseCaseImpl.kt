package com.find.android.core.domain.usecase.splash

import com.google.firebase.auth.FirebaseAuth
import javax.inject.Inject

class SplashUseCaseImpl @Inject constructor(
    private val firebaseAuth: FirebaseAuth,
) : SplashUseCase {

    override fun invoke(): Boolean = firebaseAuth.currentUser != null

}