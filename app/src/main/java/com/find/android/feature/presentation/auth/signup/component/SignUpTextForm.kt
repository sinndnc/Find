package com.find.android.feature.presentation.auth.signup.component

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign

@Composable
fun SignUpTextForm() {
    Text(
        text = "Let started",
        style = MaterialTheme.typography.h4,
        modifier = Modifier.fillMaxWidth(),
        textAlign = TextAlign.Start
    )
}