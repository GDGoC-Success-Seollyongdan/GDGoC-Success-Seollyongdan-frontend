package com.example.seollyongdan_frontend.presentation.community.navigation

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavType
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.example.seollyongdan_frontend.presentation.community.screen.CommunityDetailRoute
import com.example.seollyongdan_frontend.presentation.community.screen.CommunityReviewRoute
import com.example.seollyongdan_frontend.presentation.community.screen.CommunityRoute
import com.example.seollyongdan_frontend.presentation.community.screen.CommunitySearchRoute
import com.example.seollyongdan_frontend.presentation.community.screen.CommunityWriteRoute


fun NavGraphBuilder.communityNavGraph(
    navigator: CommunityNavigator
) {
    composable(route = "community") {
        CommunityRoute(navigator = navigator)
    }

    composable(
        route = "communitySearch?district={district}",
        arguments = listOf(
            navArgument("district") { type = NavType.StringType }
        )) { backStackEntry ->
        CommunitySearchRoute(
            navigator = navigator,
            district = (backStackEntry.arguments?.getString("district") ?: -1).toString()
        )
    }

    composable(
        route = "communityReview?district={district}",
        arguments = listOf(
            navArgument("district") { type = NavType.StringType }
        )
    ) { backStackEntry ->
        CommunityReviewRoute(
            navigator = navigator,
            district = (backStackEntry.arguments?.getString("district") ?: -1).toString()
        )
    }

    composable(
        route = "communityWrite?district={district}",
        arguments = listOf(
            navArgument("district") {type = NavType.StringType}
        )
    ) { backStackEntry ->
        CommunityWriteRoute(
            navigator = navigator,
            district = (backStackEntry.arguments?.getString("district") ?: -1).toString()

        )
    }

    composable(
        route = "communityDetail?id={id}?district={district}",
        arguments = listOf(
            navArgument("id"){type = NavType.LongType},
            navArgument("district") {type = NavType.StringType}
        )
    ) { backStackEntry ->
        CommunityDetailRoute(
            navigator = navigator,
            id = backStackEntry.arguments?.getLong("id") ?: -1,
            district = (backStackEntry.arguments?.getString("district") ?: -1).toString()
            )
    }

}