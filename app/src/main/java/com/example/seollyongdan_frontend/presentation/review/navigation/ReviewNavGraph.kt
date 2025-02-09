package com.example.seollyongdan_frontend.presentation.review.navigation

import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.example.seollyongdan_frontend.presentation.review.screen.ReviewRoute

fun NavGraphBuilder.reviewNavGraph(
    navigator: ReviewNavigator
){
    composable(route = "review") {
        ReviewRoute(navigator = navigator)
    }
}