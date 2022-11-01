package com.find.android.feature.presentation.auth.signup.component

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.unit.dp
import com.find.android.feature.component.textfield.FindTextField
import com.find.android.feature.presentation.auth.signup.SignUpViewModel

@Composable
fun SignUpColumnForm(viewModel: SignUpViewModel) {

    Column {
        FindTextField(viewModel.name, imeAction = ImeAction.Next, label = "name")
        Spacer(modifier = Modifier.height(10.dp))
        FindTextField(viewModel.email, imeAction = ImeAction.Done, label = "email")
        Spacer(modifier = Modifier.height(10.dp))
        FindTextField(viewModel.password, imeAction = ImeAction.Done, label = "password")
    }
}