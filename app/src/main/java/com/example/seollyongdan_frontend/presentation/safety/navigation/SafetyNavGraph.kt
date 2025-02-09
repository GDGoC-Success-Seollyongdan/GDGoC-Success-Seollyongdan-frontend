package com.example.seollyongdan_frontend.presentation.safety.navigation

import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.example.seollyongdan_frontend.presentation.safety.screen.SafetyRoute

fun NavGraphBuilder.safetyNavGraph(
    navigator: SafetyNavigator
) {
    composable(route = "safety") {
        SafetyRoute(navigator = navigator)
    }
}