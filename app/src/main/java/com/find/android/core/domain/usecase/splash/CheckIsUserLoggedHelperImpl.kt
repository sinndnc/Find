package com.find.android.core.domain.usecase.splash

import com.google.firebase.auth.FirebaseAuth
import javax.inject.Inject

class CheckIsUserLoggedHelperImpl @Inject constructor(
    private val firebaseAuth: FirebaseAuth,
) : CheckIsUserLoggedHelper {

    override fun invoke(): Boolean = firebaseAuth.currentUser != null

}