package com.find.android.core.util.permission

import androidx.activity.compose.ManagedActivityResultLauncher

interface PermissionHelper {

    fun checkAndRequestMultiplePermissions(
        permissions: Array<String>,
        launcher: ManagedActivityResultLauncher<Array<String>, Map<String, Boolean>>,
        onGranted: () -> Unit,
    )


    fun checkAndRequestPermission(
        permission: String,
        launcher: ManagedActivityResultLauncher<String,Boolean>,
        onGranted: () -> Unit,
    )

}