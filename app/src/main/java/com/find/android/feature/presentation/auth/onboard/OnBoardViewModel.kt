package com.find.android.feature.presentation.auth.onboard

import androidx.lifecycle.ViewModel
import androidx.navigation.NavController
import com.find.android.feature.navigation.Content
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class OnBoardViewModel @Inject constructor() : ViewModel() {

    fun navigateToLoginContent(navController: NavController){
        navController.navigate(Content.Login.route)
    }

    fun navigateToSignUpContent(navController: NavController){
        navController.navigate(Content.SignUp.route)
    }
}