package com.example.seollyongdan_frontend.presentation.review.navigation

import androidx.navigation.NavController

class ReviewNavigator(
    val navController: NavController
) {
    fun navigateBack(){
        navController.popBackStack()
    }
}