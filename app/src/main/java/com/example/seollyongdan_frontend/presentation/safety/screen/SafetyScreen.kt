package com.example.seollyongdan_frontend.presentation.safety.screen

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import com.example.seollyongdan_frontend.presentation.safety.navigation.SafetyNavigator
import com.example.seollyongdan_frontend.ui.theme.White
import com.google.accompanist.systemuicontroller.rememberSystemUiController

@Composable
fun SafetyRoute(
    navigator: SafetyNavigator
){
    val systemUiController = rememberSystemUiController()

    SideEffect {
        systemUiController.setStatusBarColor(
            color = White
        )
    }
    SafetyScreen()
}

@Composable
fun SafetyScreen(

) {
    Text("안전 및 치안 화면입니다.")
}