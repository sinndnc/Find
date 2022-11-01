package com.find.android.feature.presentation.auth.signup.views

import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.find.android.feature.presentation.auth.signup.SignUpViewModel
import com.find.android.feature.presentation.auth.signup.component.SignUpColumnForm
import com.find.android.feature.presentation.auth.signup.component.SignUpTextForm

@Composable
fun ColumnScope.SignUpForm(viewModel: SignUpViewModel, navController: NavController) {

    Column(
        modifier = Modifier.weight(0.4f).padding(20.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceEvenly,
    ) {
        SignUpTextForm()
        SignUpColumnForm(viewModel)
    }

}