package com.example.seollyongdan_frontend.presentation.safety.navigation

import androidx.navigation.NavController

class SafetyNavigator(
    val navController: NavController
) {
    fun navigateBack() {
        navController.popBackStack()
    }
}