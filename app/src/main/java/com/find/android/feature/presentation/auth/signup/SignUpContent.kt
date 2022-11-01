package com.find.android.feature.presentation.auth.signup

import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalFocusManager
import androidx.navigation.NavController
import com.find.android.feature.presentation.auth.signup.views.SignUpBar
import com.find.android.feature.presentation.auth.signup.views.SignUpBottomForm
import com.find.android.feature.presentation.auth.signup.views.SignUpForm
import com.find.android.feature.util.extension.noRippleClickable
import com.find.android.feature.util.extension.setThemeBackground

@Composable
fun SignUpContent(viewModel: SignUpViewModel, navController: NavController) {

    val focusManager = LocalFocusManager.current

    Column(
        modifier = Modifier
            .fillMaxSize()
            .setThemeBackground()
            .navigationBarsPadding()
            .noRippleClickable { focusManager.clearFocus() },
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        SignUpBar(viewModel, navController)
        SignUpForm(viewModel, navController)
        SignUpBottomForm(viewModel, navController)
    }
}