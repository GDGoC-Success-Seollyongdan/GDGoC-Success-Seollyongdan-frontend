package com.example.seollyongdan_frontend.presentation.auth.screen

import androidx.compose.foundation.layout.Box
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import com.example.seollyongdan_frontend.presentation.auth.navigation.AuthNavigator
import com.example.seollyongdan_frontend.presentation.auth.screen.LoginScreen
import com.example.seollyongdan_frontend.ui.theme.SeollyongdanfrontendTheme
import com.google.accompanist.systemuicontroller.rememberSystemUiController

@Composable
fun SignUpRoute(
    navigator: AuthNavigator
){
    val systemUiController = rememberSystemUiController()

    SideEffect {
        systemUiController.setStatusBarColor(
            color = Color.White
        )
    }

    SignUpScreen(
        onNextClick = {
            navigator.navigateLogin()
        }
    )
}

@Composable
fun SignUpScreen(
    onNextClick : () -> Unit = {}
){
    Button(onClick = onNextClick) { Text("회원가입 완료")}
}

@Preview
@Composable
fun SignUpScreenPreview() {
    SeollyongdanfrontendTheme  {
        SignUpScreen(
            onNextClick = {}
        )
    }
}