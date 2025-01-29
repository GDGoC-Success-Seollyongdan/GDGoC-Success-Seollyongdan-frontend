package com.example.seollyongdan_frontend.presentation.home.navigation

import androidx.navigation.NavController

class HomeNavigator(
    val navController: NavController
){
    fun navigateBack(){
        navController.popBackStack()
    }
}