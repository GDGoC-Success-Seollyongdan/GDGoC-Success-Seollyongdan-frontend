package com.example.seollyongdan_frontend.presentation.search.navigation

import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.example.seollyongdan_frontend.presentation.search.screen.SearchResultRoute
import com.example.seollyongdan_frontend.presentation.search.screen.SearchRoute


fun NavGraphBuilder.searchNavGraph(
    navigator: SearchNavigator
){
    composable(route = "search"){
        SearchRoute(navigator = navigator)
    }
    composable(route = "search_result"){
        SearchResultRoute(navigator = navigator)
    }
}