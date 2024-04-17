package com.packt.chapterthirteen.views

import android.app.Activity
import android.content.Context
import android.content.pm.PackageManager
import android.util.Log
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import com.packt.chapterthirteen.data.PermissionAction

@Composable
fun PermissionDialog(
    context: Context,
    permission: String,
    permissionAction: (PermissionAction) -> Unit
) {
    val isPermissionGranted = checkIfPermissionGranted(context, permission)

    if (isPermissionGranted) {
        permissionAction(PermissionAction.PermissionGranted)
        return
    }

    val permissionsLauncher = rememberLauncherForActivityResult(
        ActivityResultContracts.RequestPermission()
    ) { isGranted: Boolean ->
        if (isGranted) {
            permissionAction(PermissionAction.PermissionGranted)
        } else {
            permissionAction(PermissionAction.PermissionDenied)
        }
    }

    val showPermissionRationale = shouldShowPermissionRationale(context, permission)
    var isDialogDismissed by remember { mutableStateOf(false) }
    var isPristine by remember { mutableStateOf(true) }

    if ((showPermissionRationale && !isDialogDismissed) || (!isDialogDismissed && !isPristine)) {
        isPristine = false
        AlertDialog(
            onDismissRequest = {
                isDialogDismissed = true
                permissionAction(PermissionAction.PermissionDenied)
            },
            title = { Text(text = "Permission Required") },
            text = { Text(text = "This app requires the location permission to be granted.") },
            confirmButton = {
                Button(
                    onClick = {
                        isDialogDismissed = true
                        permissionsLauncher.launch(permission)
                    }
                ) {
                    Text(text = "Grant Access")
                }
            },
            dismissButton = {
                Button(
                    onClick = {
                        isDialogDismissed = true
                        permissionAction(PermissionAction.PermissionDenied)
                    }
                ) {
                    Text(text = "Cancel")
                }
            }
        )
    } else {
        if (!isDialogDismissed) {
            SideEffect {
                permissionsLauncher.launch(permission)
            }
        }
    }
}

fun checkIfPermissionGranted(context: Context, permission: String): Boolean {
    return (
        ContextCompat.checkSelfPermission(context, permission)
            == PackageManager.PERMISSION_GRANTED
        )
}

fun shouldShowPermissionRationale(context: Context, permission: String): Boolean {
    val activity = context as Activity?
    if (activity == null) {
        Log.d("Permissions", "Activity is null")
    }

    return ActivityCompat.shouldShowRequestPermissionRationale(
        activity!!,
        permission
    )
}