package com.example.seollyongdan_frontend.presentation.main.navigation

import androidx.navigation.NavHostController

class MainNavigator(
    val navController: NavHostController
){
    fun navigateBack(){
        navController.popBackStack()
    }
}