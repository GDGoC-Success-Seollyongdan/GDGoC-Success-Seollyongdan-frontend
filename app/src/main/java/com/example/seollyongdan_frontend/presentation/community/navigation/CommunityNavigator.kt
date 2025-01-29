package com.example.seollyongdan_frontend.presentation.community.navigation

import androidx.navigation.NavController

class CommunityNavigator(
    val navController: NavController
){
    fun navigateBack(){
        navController.popBackStack()
    }
}