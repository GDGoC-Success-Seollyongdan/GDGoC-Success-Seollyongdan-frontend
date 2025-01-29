package com.example.seollyongdan_frontend.presentation.guide.navigation

import androidx.navigation.NavController

class GuideNavigator(
    val navController: NavController
){
    fun navigateBack(){
        navController.popBackStack()
    }
}