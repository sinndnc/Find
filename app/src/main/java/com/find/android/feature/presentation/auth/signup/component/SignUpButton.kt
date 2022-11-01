package com.find.android.feature.presentation.auth.signup.component

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.imePadding
import androidx.compose.foundation.layout.padding
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.find.android.feature.presentation.auth.signup.SignUpViewModel
import com.find.android.feature.util.state.UiState

@Composable
fun SignUpButton(viewModel: SignUpViewModel, onClick: () -> Unit) {

    val themeColor = MaterialTheme.colors
    val themeTypography = MaterialTheme.typography

    Box(
        modifier = Modifier.fillMaxWidth(),
        contentAlignment = Alignment.CenterEnd
    ) {
        OutlinedButton(
            enabled = viewModel.uiState.value != UiState.Loading,
            modifier = Modifier.imePadding(),
            colors = ButtonDefaults.buttonColors(
                backgroundColor = themeColor.primary,
            ),
            onClick = onClick,
        ) {
            Text(
                modifier = Modifier.padding(horizontal = 5.dp),
                text = "Next",
                style = themeTypography.button,
                color = themeColor.onPrimary
            )
        }
    }

}