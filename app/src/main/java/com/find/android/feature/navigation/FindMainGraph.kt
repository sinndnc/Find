package com.find.android.feature.navigation

import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.compose.navigation
import com.find.android.feature.presentation.main.home.HomeContent
import com.find.android.feature.presentation.main.home.HomeViewModel

fun NavGraphBuilder.findMainGraph(navController: NavController) {
    navigation(
        route = Content.MAIN_GRAPH,
        startDestination = Content.Home.route
    ) {
        composable(Content.Home.route) {
            val homeViewModel = hiltViewModel<HomeViewModel>()
            HomeContent(viewModel = homeViewModel, navController = navController)
        }
    }
}