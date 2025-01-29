package com.example.seollyongdan_frontend.presentation.community.navigation

import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable


fun NavGraphBuilder.communityNavGraph(
    navigator: CommunityNavigator
){
    composable(route = "community"){
        CommunityRoute(navigator = navigator)
    }

}