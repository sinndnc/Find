package com.find.android.feature.presentation.main.privacy.view

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController

@Composable
fun PrivacyAppBar(navController: NavController) {

    val typography = MaterialTheme.typography

    Row(
        modifier = Modifier
            .statusBarsPadding()
            .wrapContentHeight()
            .fillMaxWidth()
            .padding(20.dp),
        horizontalArrangement = Arrangement.Start,
    ) {
        Icon(
            Icons.Rounded.ArrowBack, modifier = Modifier
                .size(27.dp)
                .padding(2.dp)
                .clip(CircleShape)
                .clickable {
                    navController.popBackStack()
                }, contentDescription = "arrowBack"
        )
        Spacer(modifier = Modifier.width(10.dp))
        Text("Privacy", style = typography.h6)
    }
}