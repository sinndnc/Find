package com.find.android.feature.presentation.auth.login.views

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
import com.find.android.feature.presentation.auth.login.LoginViewModel

@Composable
fun ColumnScope.LoginAppBar(viewModel: LoginViewModel, navController: NavController) {

    Row(
        modifier = Modifier
            .weight(0.1f)
            .padding(horizontal = 10.dp)
            .fillMaxWidth(),
        horizontalArrangement = Arrangement.Start,
        verticalAlignment = Alignment.Bottom,
    ) {
        IconButton(onClick = {
            viewModel.navigateToBackContent(navController)
        }) {
            Icon(imageVector = Icons.Rounded.ArrowBack, contentDescription = "Arrow back")
        }
    }
}