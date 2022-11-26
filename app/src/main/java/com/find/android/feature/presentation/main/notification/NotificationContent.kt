package com.find.android.feature.presentation.main.notification

import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import com.find.android.feature.presentation.main.notification.view.NotificationAppBar

@Composable
fun NotificationContent(
    viewModel: NotificationViewModel,
    navController: NavController
) {

    Column() {
        NotificationAppBar(navController)
    }
}