package com.example.seollyongdan_frontend.presentation.example.navigation

import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.example.sellyongdan_frontend.presentation.example.screen.ExampleRoute

fun NavGraphBuilder.exampleNavGraph(
    navigator: ExampleNavigator
) {
    composable(route = "example") {
        ExampleRoute(navigator = navigator)
    }
}