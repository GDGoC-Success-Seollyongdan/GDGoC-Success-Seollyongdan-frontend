package com.example.seollyongdan_frontend.presentation.mypage.navigation

import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.example.seollyongdan_frontend.presentation.mypage.screen.MypageRoute

fun NavGraphBuilder.mypageNavGraph(
    navigator: MypageNavigator
){
    composable(route = "home"){
        MypageRoute(navigator = navigator)
    }

}