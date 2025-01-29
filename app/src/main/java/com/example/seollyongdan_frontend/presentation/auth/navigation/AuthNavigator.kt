package com.example.seollyongdan_frontend.presentation.auth.navigation

import androidx.navigation.NavController

class AuthNavigator(
    val navController: NavController
){
    fun navigateBack(){
        navController.popBackStack()
    }

    fun navigateLogin(){
        navController.navigate(route = "login")
    }

    fun navigateMain(){
        navController.navigate(route = "main"){
            popUpTo(0){
                inclusive = true
            }
        }
    }

    fun navigateSignUp(){
        navController.navigate(route = "signup")
    }
}