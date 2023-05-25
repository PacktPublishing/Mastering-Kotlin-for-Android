package com.packt.dscmku

import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithText
import com.packt.dscmku.ui.theme.LoginState
import org.junit.Test

class LoginTest {
    val composeTestRule = createComposeRule()

    @Test
    fun testLogin() {
        with(composeTestRule) {
            setContent {
                LoginScreenContent(
                    loginState = LoginState(),
                    onEmailChanged = {},
                    onPasswordChanged = {},
                    onLogin = {}
                )
            }

            onNodeWithText("Login").assertExists()
        }
    }

}