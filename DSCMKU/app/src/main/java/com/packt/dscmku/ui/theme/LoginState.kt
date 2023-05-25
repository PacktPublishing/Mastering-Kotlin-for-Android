package com.packt.dscmku.ui.theme

data class LoginState(
    val email: String? = null,
    val password: String? = null,
    val isLoading: Boolean = false
) {
    val isValid: Boolean
        get() = email != null && password != null
}

sealed class LoginEvents {
    data class EmailChanged(val email: String): LoginEvents()
    data class PasswordChanged(val password: String): LoginEvents()
    object LoginClicked: LoginEvents()
}
