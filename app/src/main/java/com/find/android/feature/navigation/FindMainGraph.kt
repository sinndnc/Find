package com.find.android.feature.navigation

import androidx.compose.animation.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.compose.navigation
import com.find.android.feature.presentation.main.home.HomeContent
import com.find.android.feature.presentation.main.home.HomeViewModel
import com.find.android.feature.presentation.main.language.LanguageContent
import com.find.android.feature.presentation.main.language.LanguageViewModel
import com.find.android.feature.presentation.main.notFound.NotFoundContent
import com.find.android.feature.presentation.main.notification.NotificationContent
import com.find.android.feature.presentation.main.notification.NotificationViewModel
import com.find.android.feature.presentation.main.privacy.PrivacyContent
import com.find.android.feature.presentation.main.privacy.PrivacyViewModel

fun NavGraphBuilder.findMainGraph(navController: NavController) {
    navigation(
        route = Content.MAIN_GRAPH,
        startDestination = Content.Home.route
    ) {
        composable(Content.Home.route) {
            val homeViewModel = hiltViewModel<HomeViewModel>()
            HomeContent(viewModel = homeViewModel, navController = navController)
        }
        composable(Content.Language.route) {
            val languageViewModel = hiltViewModel<LanguageViewModel>()
            LanguageContent(languageViewModel, navController)
        }
        composable(Content.Notification.route) {
            val notificationViewModel = hiltViewModel<NotificationViewModel>()
            NotificationContent(notificationViewModel, navController)
        }
        composable(Content.Privacy.route) {
            val privacyViewModel = hiltViewModel<PrivacyViewModel>()
            EnterAnimation { PrivacyContent(privacyViewModel, navController) }
        }
        composable(Content.NotFound.route) {
            NotFoundContent()
        }
    }
}


@Composable
fun EnterAnimation(content: @Composable () -> Unit) {
    AnimatedVisibility(
        visible = true,
        enter = slideInVertically(
            initialOffsetY = { -40 }
        ) + expandVertically(
            expandFrom = Alignment.Top
        ) + fadeIn(initialAlpha = 0.3f),
        exit = slideOutVertically() + shrinkVertically() + fadeOut(),
        content = { content() },
    )
}