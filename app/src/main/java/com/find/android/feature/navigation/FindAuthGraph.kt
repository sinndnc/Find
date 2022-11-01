package com.find.android.feature.navigation

import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.find.android.feature.presentation.auth.login.LoginContent
import com.find.android.feature.presentation.auth.login.LoginViewModel
import com.find.android.feature.presentation.auth.onboard.OnBoardContent
import com.find.android.feature.presentation.auth.onboard.OnBoardViewModel
import com.find.android.feature.presentation.auth.signup.SignUpContent
import com.find.android.feature.presentation.auth.signup.SignUpViewModel

fun NavGraphBuilder.findAuthGraph(navController : NavController) {
    navigation(
        startDestination = Content.OnBoard.route,
        route = Content.AUTH_GRAPH
    ) {
        composable(Content.OnBoard.route) {
            val onBoardViewModel = hiltViewModel<OnBoardViewModel>()
            OnBoardContent(viewModel = onBoardViewModel, navController = navController)
        }
        composable(Content.Login.route) {
            val loginViewModel = hiltViewModel<LoginViewModel>()
            LoginContent(viewModel = loginViewModel, navController = navController)
        }
        composable(Content.SignUp.route) {
            val signUpViewModel = hiltViewModel<SignUpViewModel>()
            SignUpContent(viewModel = signUpViewModel, navController = navController)
        }
    }
}