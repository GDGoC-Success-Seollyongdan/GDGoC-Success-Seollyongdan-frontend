package com.example.seollyongdan_frontend.presentation.search.navigation

import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable

fun NavGraphBuilder.searchNavGraph(
    navigator: SearchNavigator
){
    composable(route = "search"){
        SearchRoute(navigator = navigator)
    }
}