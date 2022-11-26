package com.find.android.feature.presentation.main.privacy

import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import com.find.android.feature.presentation.main.privacy.view.PrivacyAppBar

@Composable
fun PrivacyContent(viewModel: PrivacyViewModel, navController: NavController) {

    Column() {
        PrivacyAppBar(navController)
    }
}