package com.find.android.feature.presentation.auth.onboard

import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.find.android.feature.presentation.auth.onboard.views.OnBoardLoginForm
import com.find.android.feature.presentation.auth.onboard.views.OnBoardSignUpForm

@Composable
fun OnBoardContent(viewModel: OnBoardViewModel, navController: NavController) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = 20.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        //Todo(adding ui)
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .weight(0.75f)
        )
        OnBoardLoginForm(viewModel,navController)
        OnBoardSignUpForm(viewModel,navController)
    }
}