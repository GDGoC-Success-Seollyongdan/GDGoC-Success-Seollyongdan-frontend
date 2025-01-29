package com.example.seollyongdan_frontend.presentation.community.navigation

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.ui.graphics.Color
import com.google.accompanist.systemuicontroller.rememberSystemUiController

@Composable
fun CommunityRoute(
    navigator: CommunityNavigator
){
    val systemUiController = rememberSystemUiController()

    SideEffect {
        systemUiController.setStatusBarColor(
            color = Color.White
        )
    }

    CommunityScreen()
}

@Composable
fun CommunityScreen(){

    Text("커뮤니티 화면입니다.")
}