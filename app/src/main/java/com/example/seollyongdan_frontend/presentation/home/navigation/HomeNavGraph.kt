package com.example.seollyongdan_frontend.presentation.home.navigation

import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.example.seollyongdan_frontend.presentation.home.screen.HomeRoute
import com.example.seollyongdan_frontend.presentation.life.screen.LifeScreen
import com.example.seollyongdan_frontend.presentation.realestate.navigation.RealEstateNavigator
import com.example.seollyongdan_frontend.presentation.realestate.screen.RealEstateScreen
import com.example.seollyongdan_frontend.presentation.review.screen.ReviewScreen
import com.example.seollyongdan_frontend.presentation.safety.screen.SafetyRoute
import com.example.seollyongdan_frontend.presentation.safety.screen.SafetyScreen
import com.example.seollyongdan_frontend.presentation.search.screen.SearchScreen
import com.example.seollyongdan_frontend.presentation.traffic.screen.TrafficScreen


fun NavGraphBuilder.homeNavGraph(
    navigator: HomeNavigator
){
    composable(route = "home"){
        HomeRoute(navigator = navigator)
    }
    composable(route = "safety") {
        SafetyScreen()
    }
    composable(route = "realestate") {
        RealEstateScreen()
    }
    composable(route = "traffic") {
        TrafficScreen()
    }
    composable(route = "life") {
        LifeScreen()
    }
    composable(route = "review") {
        ReviewScreen()
    }
    composable(route = "search") {
        SearchScreen()
    }
}