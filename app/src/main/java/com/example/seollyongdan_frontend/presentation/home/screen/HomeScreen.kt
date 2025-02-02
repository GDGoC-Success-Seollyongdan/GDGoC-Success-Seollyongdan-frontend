package com.example.seollyongdan_frontend.presentation.home.screen

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.ui.graphics.Color
import com.google.accompanist.systemuicontroller.rememberSystemUiController
import com.example.seollyongdan_frontend.presentation.home.navigation.HomeNavigator

@Composable
fun HomeRoute(
    navigator: HomeNavigator
){
    val systemUiController = rememberSystemUiController()

    SideEffect {
        systemUiController.setStatusBarColor(
            color = Color.White
        )
    }

    HomeScreen()
}

@Composable
fun HomeScreen(){

    Text("홈 화면입니다.")
}