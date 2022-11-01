package com.find.android.feature.presentation.main.profile.component

import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.find.android.feature.presentation.main.profile.model.ProfileColumnItems

@Composable
fun ProfileListsRow() {

    val categoryList = listOf(ProfileColumnItems.Lists, ProfileColumnItems.Preferences, ProfileColumnItems.Account)

    for (category in categoryList) {
        Column(
            modifier = Modifier.padding(20.dp),
            verticalArrangement = Arrangement.SpaceAround,
            horizontalAlignment = Alignment.Start
        ) {
            Text(text = category.name, color = Color.Gray)
            for (item in category.items) {
                Spacer(Modifier.height(10.dp))
                ProfileItemRow(item.name, item.icon)
            }
        }
    }

}