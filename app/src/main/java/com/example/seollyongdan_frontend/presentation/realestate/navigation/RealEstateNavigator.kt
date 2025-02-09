package com.example.seollyongdan_frontend.presentation.realestate.navigation

import androidx.navigation.NavController

class RealEstateNavigator(
    val navController : NavController
) {
    fun navigateBack() {
        navController.popBackStack()
    }
}