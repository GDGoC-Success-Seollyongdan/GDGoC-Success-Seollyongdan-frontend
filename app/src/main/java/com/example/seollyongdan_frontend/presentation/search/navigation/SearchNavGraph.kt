package com.example.seollyongdan_frontend.presentation.search.navigation

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavType
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.example.seollyongdan_frontend.presentation.community.screen.CommunityWriteRoute
import com.example.seollyongdan_frontend.presentation.search.screen.SearchResultRoute
import com.example.seollyongdan_frontend.presentation.search.screen.SearchRoute


fun NavGraphBuilder.searchNavGraph(
    navigator: SearchNavigator
){
    composable(route = "search"){
        SearchRoute(navigator = navigator)
    }

    composable(route = "search_result?safety={safety}&traffic={traffic}&real_estate={real_estate}&amenities={amenities}",
        arguments = listOf(
            navArgument("safety") { type = NavType.StringType },
            navArgument("traffic") { type = NavType.StringType },
            navArgument("real_estate") { type = NavType.StringType },
            navArgument("amenities") { type = NavType.StringType }
        )

        ){backStackEntry ->
        SearchResultRoute(navigator = navigator,
            safety = backStackEntry.arguments?.getString("safety") ?: "",
            traffic = backStackEntry.arguments?.getString("traffic") ?: "",
            real_estate = backStackEntry.arguments?.getString("real_estate") ?: "",
            amenities = backStackEntry.arguments?.getString("amenities") ?: ""
            )
    }


}