package com.example.seollyongdan_frontend.presentation.traffic.navigation

import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.example.seollyongdan_frontend.presentation.traffic.screen.TrafficRoute

fun NavGraphBuilder.trafficNavGraph(
    navigator: TrafficNavigator
) {
    composable(route = "traffic") {
        TrafficRoute(navigator = navigator)
    }
}