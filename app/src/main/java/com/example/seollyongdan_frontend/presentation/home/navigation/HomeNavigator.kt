package com.example.seollyongdan_frontend.presentation.home.navigation

import androidx.navigation.NavController

class HomeNavigator(
    val navController: NavController
){
    fun navigateBack(){
        navController.popBackStack()
    }
    fun navigateToSafety() {
        navController.navigate("safety")
    }
    fun navigateToRealEstate() {
        navController.navigate("realestate")
    }
    fun navigateToTraffic() {
        navController.navigate("traffic")
    }
    fun navigateToLife() {
        navController.navigate("life")
    }
    fun navigateToReview() {
        navController.navigate("review")
    }
    fun navigateToSearch() {
        navController.navigate("search")
    }
}