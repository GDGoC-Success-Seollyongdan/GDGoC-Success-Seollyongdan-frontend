package com.example.seollyongdan_frontend.presentation.auth.navigation

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.rememberNavController
import com.example.seollyongdan_frontend.presentation.main.navigation.MainScreen
import com.example.seollyongdan_frontend.ui.theme.SellyongdanfrontendTheme
import com.google.accompanist.systemuicontroller.rememberSystemUiController

@Composable
fun LoginRoute(
    navigator: AuthNavigator
){
    val systemUiController = rememberSystemUiController()

    SideEffect {
        systemUiController.setStatusBarColor(
            color = Color.White
        )
    }

    LoginScreen(
        onMainClick = {navigator.navigateMain()},
        onSignUpClick = {navigator.navigateSignUp()}
    )
}

@Composable
fun LoginScreen(
    onMainClick: () -> Unit = {},
    onSignUpClick: () -> Unit = {}
){

    Column {
        Button(onClick = onMainClick) { Text("로그인")}

        Button(onClick = onSignUpClick) { Text("회원가입")}

    }

}

@Preview
@Composable
fun LoginScreenPreview() {
    SellyongdanfrontendTheme  {
        LoginScreen(
            onMainClick = {},
            onSignUpClick = {}
        )
    }
}