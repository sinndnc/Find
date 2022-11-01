package com.find.android.feature.presentation.auth.login.component

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign

@Composable
fun LoginTextForm() {
    Text(
        text = "Welcome Back",
        style = MaterialTheme.typography.h4,
        modifier = Modifier.fillMaxWidth(),
        textAlign = TextAlign.Start
    )
}