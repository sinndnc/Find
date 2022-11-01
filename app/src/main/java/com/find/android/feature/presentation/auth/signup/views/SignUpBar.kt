package com.find.android.feature.presentation.auth.signup.views

import androidx.compose.foundation.layout.*
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.find.android.feature.presentation.auth.signup.SignUpViewModel

@Composable
fun ColumnScope.SignUpBar(viewModel: SignUpViewModel, navController: NavController) {

    Row(
        modifier = Modifier
            .weight(0.1f)
            .fillMaxWidth()
            .padding(top = 10.dp, start = 10.dp),
        verticalAlignment = Alignment.Bottom,
        horizontalArrangement = Arrangement.Start
    ) {
        IconButton(onClick = {
            viewModel.navigateToBackContent(navController)
        }) {
            Icon(imageVector = Icons.Rounded.ArrowBack, contentDescription = "Arrow back")
        }
    }
}