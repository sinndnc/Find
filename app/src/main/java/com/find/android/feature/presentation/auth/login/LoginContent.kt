package com.find.android.feature.presentation.auth.login

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalFocusManager
import androidx.navigation.NavController
import com.find.android.feature.presentation.auth.login.views.LoginAppBar
import com.find.android.feature.presentation.auth.login.views.LoginForm
import com.find.android.feature.util.extension.noRippleClickable
import com.find.android.feature.util.extension.setThemeBackground

@Composable
fun LoginContent(viewModel: LoginViewModel, navController: NavController) {

    val focusManager = LocalFocusManager.current

    Column(
        modifier = Modifier
            .fillMaxSize()
            .setThemeBackground()
            .noRippleClickable { focusManager.clearFocus() },
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        LoginAppBar(viewModel, navController)
        LoginForm(viewModel, navController)
        //Todo(adding ui)
        Box(
            modifier = Modifier
                .weight(0.45f)
                .fillMaxWidth()
        )
    }
}