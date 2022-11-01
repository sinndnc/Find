package com.find.android.feature.presentation.auth.signup.views

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.find.android.core.domain.model.SignUpModel
import com.find.android.feature.presentation.auth.signup.SignUpViewModel
import com.find.android.feature.presentation.auth.signup.component.SignUpButton

@Composable
fun ColumnScope.SignUpBottomForm(viewModel: SignUpViewModel, navController: NavController) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .padding(20.dp)
            .weight(0.45f),
        contentAlignment = Alignment.BottomCenter
    ) {
        SignUpButton(viewModel) {
            viewModel.createUserWithEmailAndPassword(
                SignUpModel("sinan", viewModel.email.value, viewModel.password.value),
                navController
            )
        }
    }
}