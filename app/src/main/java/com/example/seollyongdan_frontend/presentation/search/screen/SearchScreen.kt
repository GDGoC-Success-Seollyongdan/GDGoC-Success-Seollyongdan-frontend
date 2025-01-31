package com.example.seollyongdan_frontend.presentation.search.screen

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.ui.graphics.Color
import com.example.seollyongdan_frontend.presentation.search.navigation.SearchNavigator
import com.google.accompanist.systemuicontroller.rememberSystemUiController

@Composable
fun SearchRoute(
    navigator: SearchNavigator
){
    val systemUiController = rememberSystemUiController()

    SideEffect {
        systemUiController.setStatusBarColor(
            color = Color.White
        )
    }

    SearchScreen()
}

@Composable
fun SearchScreen(){

    Text("검색 및 추천 화면입니다.")
}