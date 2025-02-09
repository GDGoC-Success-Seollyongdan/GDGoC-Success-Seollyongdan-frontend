package com.example.seollyongdan_frontend.presentation.life.navigation

import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.example.seollyongdan_frontend.presentation.life.screen.LifeRoute

fun NavGraphBuilder.lifeNavGraph(
    navigator: LifeNavigator
) {
    composable(route = "life") {
        LifeRoute(navigator = navigator)
    }
}