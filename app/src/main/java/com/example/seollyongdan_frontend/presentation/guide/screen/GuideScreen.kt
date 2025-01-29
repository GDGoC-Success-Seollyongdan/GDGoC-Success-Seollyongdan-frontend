package com.example.seollyongdan_frontend.presentation.guide.navigation

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.ui.graphics.Color
import com.google.accompanist.systemuicontroller.rememberSystemUiController

@Composable
fun GuideRoute(
    navigator: GuideNavigator
){
    val systemUiController = rememberSystemUiController()

    SideEffect {
        systemUiController.setStatusBarColor(
            color = Color.White
        )
    }

    GuideScreen()
}

@Composable
fun GuideScreen(){

    Text("가이드북 화면입니다.")
}