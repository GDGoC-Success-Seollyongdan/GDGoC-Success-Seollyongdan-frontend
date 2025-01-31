package com.example.seollyongdan_frontend.presentation.auth.navigation

import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.example.seollyongdan_frontend.presentation.auth.screen.SignUpRoute
import com.example.seollyongdan_frontend.presentation.auth.screen.LoginRoute


fun NavGraphBuilder.loginNavGraph(
    navigator: AuthNavigator
){
    composable(route = "login"){
        LoginRoute(navigator = navigator)
    }
}

fun NavGraphBuilder.signUpNavGraph(
    navigator: AuthNavigator
){
    composable(route = "signup"){
        SignUpRoute(navigator = navigator)
    }
}