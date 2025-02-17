package com.example.seollyongdan_frontend.presentation.home.navigation

import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.example.seollyongdan_frontend.presentation.home.screen.HomeRoute
import com.example.seollyongdan_frontend.presentation.home.screen.SafetyVisualizationRoute
import com.example.seollyongdan_frontend.presentation.home.screen.TrafficVisualizationRoute


fun NavGraphBuilder.homeNavGraph(
    navigator: HomeNavigator
){
    composable(route = "home"){
        HomeRoute(navigator = navigator)
    }

    composable(route = "trafficVisualization"){
        TrafficVisualizationRoute(navigator = navigator)
    }

    composable(route = "safetyVisualization"){
        SafetyVisualizationRoute(navigator = navigator)
    }
}