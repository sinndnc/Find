package com.find.android.feature.navigation

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import com.find.android.feature.util.extension.setThemeBackground

@Composable
fun FindNavigationGraph() {
    val navController = rememberNavController()

    NavHost(
        modifier = Modifier
            .fillMaxSize()
            .setThemeBackground(),
        navController = navController,
        startDestination = Content.Splash.route,
    ) {
        findSplashGraph(navController = navController)
        findAuthGraph(navController = navController)
        findMainGraph(navController = navController)
    }
}