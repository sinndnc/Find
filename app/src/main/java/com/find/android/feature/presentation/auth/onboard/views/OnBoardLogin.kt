package com.find.android.feature.presentation.auth.onboard.views

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.find.android.feature.presentation.auth.onboard.OnBoardViewModel

@Composable
fun ColumnScope.OnBoardLoginForm(viewModel: OnBoardViewModel, navController: NavController) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .weight(0.1f),
        contentAlignment = Alignment.Center
    ) {
        Button(
            onClick = {
                viewModel.navigateToLoginContent(navController)
            },
            modifier = Modifier
                .fillMaxWidth(),
            contentPadding = PaddingValues(vertical = 17.dp),
        ) {
            Text(text = "Get Started")
        }
    }
}