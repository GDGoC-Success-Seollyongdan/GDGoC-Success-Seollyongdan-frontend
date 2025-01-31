package com.example.seollyongdan_frontend.presentation.guide.navigation

import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.example.seollyongdan_frontend.presentation.guide.screen.GuideRoute

fun NavGraphBuilder.guideNavGraph(
    navigator: GuideNavigator
){
    composable(route = "guide"){
        GuideRoute(navigator = navigator)
    }
}