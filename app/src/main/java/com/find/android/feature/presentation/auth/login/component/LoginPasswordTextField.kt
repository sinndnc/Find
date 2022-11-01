package com.find.android.feature.presentation.auth.login.component

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import com.find.android.R

@Composable
fun LoginPasswordTextField(password: MutableState<String>, isVisible : MutableState<Boolean>) {

    val themeColor = MaterialTheme.colors
    val themeTypography = MaterialTheme.typography
    val focusManager = LocalFocusManager.current

    OutlinedTextField(
        value = password.value,
        onValueChange = {
            password.value = it
        },
        textStyle = themeTypography.body1,
        label = { Text("password") },
        trailingIcon = {
            IconButton(onClick = { isVisible.value = !isVisible.value }) {
                Icon(
                    painterResource(id = if (isVisible.value) R.drawable.eye_off else R.drawable.eye),
                    contentDescription = "Show password",
                    tint = themeColor.onSurface.copy(alpha = 0.5f),
                    modifier = Modifier.size(24.dp)
                )
            }
        },
        visualTransformation = if (isVisible.value) VisualTransformation.None else PasswordVisualTransformation(),
        keyboardOptions = KeyboardOptions(
            keyboardType = KeyboardType.Password,
            imeAction = ImeAction.Done
        ),
        keyboardActions = KeyboardActions(
            onDone = {
                focusManager.clearFocus()
            }
        ),
        modifier = Modifier.fillMaxWidth(),
        colors = TextFieldDefaults.outlinedTextFieldColors(
            textColor = themeColor.onSurface,
        )
    )
}