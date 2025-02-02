package com.example.seollyongdan_frontend.presentation.mypage.screen

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.ui.graphics.Color
import com.example.seollyongdan_frontend.presentation.mypage.navigation.MypageNavigator
import com.google.accompanist.systemuicontroller.rememberSystemUiController

@Composable
fun MypageRoute(
    navigator: MypageNavigator
){
    val systemUiController = rememberSystemUiController()

    SideEffect {
        systemUiController.setStatusBarColor(
            color = Color.White
        )
    }

    MypageScreen()
}

@Composable
fun MypageScreen(){

    Text("마이페이지 화면입니다.")
}