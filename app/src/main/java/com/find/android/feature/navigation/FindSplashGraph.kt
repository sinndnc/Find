package com.find.android.feature.navigation

import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.find.android.feature.presentation.splash.SplashContent
import com.find.android.feature.presentation.splash.SplashViewModel


fun NavGraphBuilder.findSplashGraph(navController : NavController){
    composable(Content.Splash.route) {
        val splashViewModel = hiltViewModel<SplashViewModel>()
        SplashContent(viewModel = splashViewModel,navController = navController)
    }
}