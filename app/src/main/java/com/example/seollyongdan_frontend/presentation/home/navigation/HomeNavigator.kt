package com.example.seollyongdan_frontend.presentation.home.navigation

import androidx.navigation.NavController

class HomeNavigator(
    val navController: NavController
){
    fun navigateBack(){
        navController.popBackStack()
    }
    fun navigateToSearch() {
        navController.navigate("search")
    }

    fun navigateToHome() {
        navController.navigate("home")
    }

    fun navigateToTrafficVisualization() {
        navController.navigate("trafficVisualization")
    }

    fun navigateToSafetyVisualization() {
        navController.navigate("safetyVisualization")
    }
}