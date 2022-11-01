package com.find.android.feature.presentation.main.profile.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.KeyboardArrowRight
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.unit.dp

@Composable
fun ProfileItemRow(name: String, icon: ImageVector) {
    val materialTheme = MaterialTheme.shapes

    Row(
        modifier = Modifier
            .background(Color.LightGray.copy(0.23f), materialTheme.medium)
            .padding(12.dp),
        horizontalArrangement = Arrangement.SpaceAround
    ) {
        Icon(icon, contentDescription = null)
        Spacer(modifier = Modifier.width(10.dp))
        Text(text = name, modifier = Modifier.weight(1f))
        Icon(Icons.Rounded.KeyboardArrowRight, contentDescription = null)
    }
}