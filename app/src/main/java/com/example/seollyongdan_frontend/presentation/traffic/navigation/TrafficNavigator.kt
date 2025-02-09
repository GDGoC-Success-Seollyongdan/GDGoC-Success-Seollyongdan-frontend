package com.example.seollyongdan_frontend.presentation.traffic.navigation

import androidx.navigation.NavController

class TrafficNavigator(
    val navController: NavController
) {
    fun navigateBack(){
        navController.popBackStack()
    }
}