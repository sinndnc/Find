package com.find.android.feature.navigation

import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.compose.navigation
import com.find.android.feature.presentation.main.home.HomeContent
import com.find.android.feature.presentation.main.home.HomeViewModel
import com.find.android.feature.presentation.main.notFound.NotFoundContent
import com.find.android.feature.presentation.main.profile.ProfileContent
import com.find.android.feature.presentation.main.profile.ProfileViewModel
import com.find.android.feature.presentation.main.notification.NotificationContent
import com.find.android.feature.presentation.main.notification.NotificationViewModel

fun NavGraphBuilder.findMainGraph(navController: NavController) {
    navigation(
        route = Content.MAIN_GRAPH,
        startDestination = Content.Home.route
    ) {
        composable(Content.Home.route) {
            val homeViewModel = hiltViewModel<HomeViewModel>()
            HomeContent(viewModel = homeViewModel, navController = navController)
        }
        composable(Content.Notification.route) {
            val notificationViewModel = hiltViewModel<NotificationViewModel>()
            NotificationContent(notificationViewModel, navController)
        }
        composable(Content.NotFound.route){
            NotFoundContent()
        }
    }
}