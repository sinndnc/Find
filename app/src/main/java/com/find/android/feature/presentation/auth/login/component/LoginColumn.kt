package com.find.android.feature.presentation.auth.login.component

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import com.find.android.feature.component.textfield.FindTextField
import com.find.android.feature.presentation.auth.login.LoginViewModel

@Composable
fun LoginColumnForm(viewModel: LoginViewModel) {
    Column {
        FindTextField(value = viewModel.email, "email", KeyboardType.Email, ImeAction.Next)
        Spacer(modifier = Modifier.height(10.dp))
        LoginPasswordTextField(password = viewModel.password, isVisible = viewModel.isVisible)
    }
}