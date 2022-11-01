package com.find.android.core.util.permission

import android.content.Context
import androidx.activity.compose.ManagedActivityResultLauncher
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Inject

class PermissionHelperImpl @Inject constructor(
    @ApplicationContext private val context: Context
) : PermissionHelper {


    override fun checkAndRequestMultiplePermissions(
        permissions: Array<String>,
        launcher: ManagedActivityResultLauncher<Array<String>, Map<String, Boolean>>,
        onGranted: () -> Unit,
    ) {
        permissions.forEach { permission ->
            when {
                context.hasPermission(permission) -> {
                    onGranted()
                }
                else -> {
                    launcher.launch(permissions)
                }
            }
        }
    }

    override fun checkAndRequestPermission(
        permission: String,
        launcher: ManagedActivityResultLauncher<String,Boolean>,
        onGranted: () -> Unit,
    ) {
        if (context.hasPermission(permission)) {
            onGranted()
        } else {
            launcher.launch(permission)
        }
    }
}