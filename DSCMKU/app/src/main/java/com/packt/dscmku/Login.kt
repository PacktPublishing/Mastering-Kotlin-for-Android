package com.packt.dscmku

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MediumTopAppBar
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SmallTopAppBar
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel
import com.packt.dscmku.ui.theme.LoginEvents
import com.packt.dscmku.ui.theme.LoginState

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LoginScreen() {
    val loginViewModel: LoginViewModel = viewModel()
    val loginState = loginViewModel.loginState.collectAsStateWithLifecycle()
    Scaffold(
        modifier = Modifier
            .fillMaxSize(),
        topBar = {
                 SmallTopAppBar(
                     title = {
                         Text(text = "Login with State")
                     }
                 )
        },
        content = { innerPadding ->
            LoginScreenContent(
                modifier = Modifier.padding(innerPadding),
                loginState = loginState.value,
                onEmailChanged = { email ->
                    loginViewModel.handleLoginEvents(LoginEvents.EmailChanged(email))
                },
                onPasswordChanged = { password ->
                    loginViewModel.handleLoginEvents(LoginEvents.PasswordChanged(password))
                },
                onLogin = { loginEvents ->
                    loginViewModel.handleLoginEvents(loginEvents)
                }
            )
        },
        containerColor = Color.LightGray
    )

}


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LoginScreenContent(
    modifier: Modifier = Modifier,
    loginState: LoginState,
    onEmailChanged: (String) -> Unit,
    onPasswordChanged: (String) -> Unit,
    onLogin: (LoginEvents) -> Unit = {}
) {
    Card(
        modifier = modifier
            .fillMaxWidth()
            .padding(8.dp),
        colors = CardDefaults.cardColors(
            containerColor = Color.White
        ),
        shape = RoundedCornerShape(16.dp),
        elevation = CardDefaults.elevatedCardElevation()
    ) {
        if (loginState.isLoading) {
           CircularProgressIndicator()

        } else {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp)
            ) {
                OutlinedTextField(
                    modifier = Modifier.fillMaxWidth(),
                    value = loginState.email ?: "",
                    label = { Text(text = "Email") },
                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email),
                    onValueChange = {
                        onEmailChanged(it)
                    }
                )

                OutlinedTextField(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 16.dp),
                    value = loginState.password ?: "",
                    label = { Text(text = "Password") },
                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
                    visualTransformation = PasswordVisualTransformation(),
                    onValueChange = {
                        onPasswordChanged(it)
                    }
                )

                Button(
                    onClick = { onLogin(LoginEvents.LoginClicked) },
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 80.dp),
                    enabled = loginState.isValid
                ) {
                    Text(text = "Login")
                }
            }
        }

    }

}



@Preview(showBackground = true)
@Composable
fun LoginScreenContentPreview() {
    LoginScreenContent(
        loginState  = LoginState(
            email = "dsc@mail.com",
            password = "123456"
        ),
        onEmailChanged = {},
        onPasswordChanged = {},
        onLogin = {}
    )
}