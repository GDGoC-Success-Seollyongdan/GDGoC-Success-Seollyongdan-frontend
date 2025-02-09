package com.example.seollyongdan_frontend.presentation.realestate.navigation

import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.example.seollyongdan_frontend.presentation.realestate.screen.RealEstateRoute

fun NavGraphBuilder.realEstateNavGraph(
    navigator : RealEstateNavigator
) {
    composable(route = "realestate") {
        RealEstateRoute(navigator = navigator)
    }
}