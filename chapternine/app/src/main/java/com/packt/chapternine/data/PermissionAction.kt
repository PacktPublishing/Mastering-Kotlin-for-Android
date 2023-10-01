package com.packt.chapternine.data

sealed class PermissionAction {
    data object PermissionGranted : PermissionAction()
    data object PermissionDenied : PermissionAction()
}
