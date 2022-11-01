package com.find.android.feature.presentation.auth.login.component

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.find.android.feature.util.state.UiState

@Composable
fun LoginButton(state: UiState, onClick: () -> Unit) {
    val themeColor = MaterialTheme.colors
    val themeTypography = MaterialTheme.typography

    Button(
        enabled = state != UiState.Loading,
        modifier = Modifier.fillMaxWidth(),
        colors = ButtonDefaults.buttonColors(
            backgroundColor = themeColor.primary,
        ),
        onClick = onClick,
    ) {
        if (state == UiState.Loading) {
            CircularProgressIndicator()
        } else {
            Text(
                modifier = Modifier.padding(vertical = 9.dp),
                text = "Login",
                style = themeTypography.button,
                color = themeColor.onPrimary
            )
        }
    }
}