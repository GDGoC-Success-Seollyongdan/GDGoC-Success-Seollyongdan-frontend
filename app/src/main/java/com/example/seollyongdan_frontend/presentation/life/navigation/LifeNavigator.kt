package com.example.seollyongdan_frontend.presentation.life.navigation

import androidx.navigation.NavController

class LifeNavigator(
    val navController: NavController
) {
    fun navigateBack() {
        navController.popBackStack()
    }
}