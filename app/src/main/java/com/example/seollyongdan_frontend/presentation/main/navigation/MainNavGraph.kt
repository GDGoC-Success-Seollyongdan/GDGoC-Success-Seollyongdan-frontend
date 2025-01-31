package com.example.seollyongdan_frontend.presentation.main.navigation

import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.example.seollyongdan_frontend.presentation.community.navigation.CommunityNavigator
import com.example.seollyongdan_frontend.presentation.guide.navigation.GuideNavigator
import com.example.seollyongdan_frontend.presentation.home.navigation.HomeNavigator
import com.example.seollyongdan_frontend.presentation.mypage.navigation.MypageNavigator
import com.example.seollyongdan_frontend.presentation.search.navigation.SearchNavigator
import com.example.seollyongdan_frontend.presentation.main.screen.MainRoute


fun NavGraphBuilder.mainNavGraph(
    mainNavigator: MainNavigator,
    homeNavigator: HomeNavigator,
    searchNavigator: SearchNavigator,
    communityNavigator: CommunityNavigator,
    guideNavigator: GuideNavigator,
    mypageNavigator: MypageNavigator
){
    composable(route = "main"){
        MainRoute(navigator = mainNavigator)
    }
}