package com.find.android.feature.presentation.main.profile.component

import androidx.compose.foundation.layout.*
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import com.find.android.R

@Composable
fun CustomDialogRow(modifier: Modifier = Modifier ,language: String, region: String, isSelected: Boolean) {
    Row(
        modifier = modifier.fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween,
    ) {
        Column(
            modifier = Modifier.wrapContentSize(),
            verticalArrangement = Arrangement.SpaceAround
        ) {
            Text(text = language)
            Text(text = "$language ($region)",style =MaterialTheme.typography.caption)
        }
        if (isSelected) Icon(painterResource(id = R.drawable.tick), contentDescription = "tick")
    }
}