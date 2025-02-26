package com.example.seollyongdan_frontend.presentation.mypage.navigation

import androidx.navigation.NavController

class MypageNavigator(
    val navController: NavController
){
    fun navigateBack(){
        navController.popBackStack()
    }

    fun navigateLogin(){
        navController.navigate(route = "login")
    }
}