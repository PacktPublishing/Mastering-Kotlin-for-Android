package com.packt.dscmku

import androidx.lifecycle.ViewModel
import com.packt.dscmku.ui.theme.LoginEvents
import com.packt.dscmku.ui.theme.LoginState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.update

class LoginViewModel: ViewModel() {
    val loginState = MutableStateFlow(LoginState())


    fun handleLoginEvents(loginEvents: LoginEvents) {
        when (loginEvents) {
            is LoginEvents.EmailChanged -> {
                loginState.update {
                    it.copy(email = loginEvents.email)
                }
            }

            is LoginEvents.PasswordChanged -> {
                loginState.update {
                    it.copy(password = loginEvents.password)
                }

            }

            is LoginEvents.LoginClicked -> {
                loginState.update {
                     it.copy(isLoading = true)                }

            }
        }
    }

    private fun login() {
       // loginState.value.email
        // loginState.value.password
        // login(email, password)
    }
}