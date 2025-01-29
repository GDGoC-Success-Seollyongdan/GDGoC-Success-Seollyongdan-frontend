package com.example.seollyongdan_frontend.presentation.search.navigation

import androidx.navigation.NavController

class SearchNavigator(
    val navController: NavController
){
    fun navigateBack(){
        navController.popBackStack()
    }
}