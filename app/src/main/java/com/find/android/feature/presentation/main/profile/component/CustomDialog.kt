package com.find.android.feature.presentation.main.profile.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Divider
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog
import com.find.android.feature.presentation.main.profile.model.language.ProfileLanguageEnum

@Composable
fun CustomDialog(openDialog: MutableState<Boolean>) {

    val configuration = LocalConfiguration.current
    val height = configuration.screenHeightDp.dp
    val width = configuration.screenWidthDp.dp
    val languages = ProfileLanguageEnum.Languages

    Dialog(onDismissRequest = {
        openDialog.value = false
    }) {
        Column(
            modifier = Modifier
                .background(Color.White, MaterialTheme.shapes.large)
                .padding(5.dp)
                .height(height * 0.4f)
                .width(width * 0.75f)
                .verticalScroll(rememberScrollState())
        ) {
            for (language in languages) {
                CustomDialogRow(
                    modifier = Modifier.padding(horizontal = 2.dp, vertical = 3.dp),
                    language = language.language,
                    region = language.region,
                    isSelected = language.language == ProfileLanguageEnum.Turkish.language
                )
                Divider(color = Color.Gray)
            }
        }
    }
}