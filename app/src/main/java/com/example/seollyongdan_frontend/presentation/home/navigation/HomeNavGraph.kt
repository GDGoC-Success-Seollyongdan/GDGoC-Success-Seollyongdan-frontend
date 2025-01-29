package com.example.seollyongdan_frontend.presentation.home.navigation

import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable

fun NavGraphBuilder.homeNavGraph(
    navigator: HomeNavigator
){
    composable(route = "home"){
        HomeRoute(navigator = navigator)
    }
}