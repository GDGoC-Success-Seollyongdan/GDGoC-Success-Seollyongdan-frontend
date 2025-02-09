package com.example.seollyongdan_frontend.presentation.life.screen

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import com.example.seollyongdan_frontend.presentation.life.navigation.LifeNavigator
import com.example.seollyongdan_frontend.ui.theme.White
import com.google.accompanist.systemuicontroller.rememberSystemUiController

@Composable
fun LifeRoute(
    navigator : LifeNavigator
) {
    val systemUiController = rememberSystemUiController()

    SideEffect {
        systemUiController.setStatusBarColor(
            color = White
        )
    }
    LifeScreen()
}

@Composable
fun LifeScreen() {
    Text("생활과 편의시설 화면입니다.")
}