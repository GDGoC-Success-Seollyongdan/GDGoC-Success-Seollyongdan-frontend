package com.example.seollyongdan_frontend.presentation.navigator

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.seollyongdan_frontend.presentation.auth.navigation.AuthNavigator
import com.example.seollyongdan_frontend.presentation.auth.navigation.loginNavGraph
import com.example.seollyongdan_frontend.presentation.auth.navigation.signUpNavGraph
import com.example.seollyongdan_frontend.presentation.auth.screen.SplashScreen
import com.example.seollyongdan_frontend.presentation.community.navigation.CommunityNavigator
import com.example.seollyongdan_frontend.presentation.community.navigation.communityNavGraph
import com.example.seollyongdan_frontend.presentation.guide.navigation.GuideNavigator
import com.example.seollyongdan_frontend.presentation.guide.navigation.guideNavGraph
import com.example.seollyongdan_frontend.presentation.home.navigation.HomeNavigator
import com.example.seollyongdan_frontend.presentation.home.navigation.homeNavGraph
import com.example.seollyongdan_frontend.presentation.life.navigation.LifeNavigator
import com.example.seollyongdan_frontend.presentation.main.navigation.MainNavigator
import com.example.seollyongdan_frontend.presentation.main.navigation.mainNavGraph
import com.example.seollyongdan_frontend.presentation.mypage.navigation.MypageNavigator
import com.example.seollyongdan_frontend.presentation.mypage.navigation.mypageNavGraph
import com.example.seollyongdan_frontend.presentation.realestate.navigation.RealEstateNavigator
import com.example.seollyongdan_frontend.presentation.review.navigation.ReviewNavigator
import com.example.seollyongdan_frontend.presentation.safety.navigation.SafetyNavigator
import com.example.seollyongdan_frontend.presentation.search.navigation.SearchNavigator
import com.example.seollyongdan_frontend.presentation.search.navigation.searchNavGraph
import com.example.seollyongdan_frontend.presentation.traffic.navigation.TrafficNavigator


@Composable
fun SeollyondanNavHost(
    modifier: Modifier = Modifier,
    navController: NavHostController,
    authNavigator: AuthNavigator,
    homeNavigator : HomeNavigator,
    communityNavigator: CommunityNavigator,
    guideNavigator: GuideNavigator,
    mainNavigator: MainNavigator,
    mypageNavigator: MypageNavigator,
    searchNavigator: SearchNavigator
){
    Box(
        modifier = modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.background)
    )
    NavHost(
        navController = navController,
        startDestination = "splash",
    ){
        composable("splash"){ SplashScreen(navController = authNavigator.navController)}

        mainNavGraph(
            mainNavigator,
            homeNavigator,
            searchNavigator,
            communityNavigator,
            guideNavigator,
            mypageNavigator
        )
        homeNavGraph(homeNavigator)
        searchNavGraph(searchNavigator)
        communityNavGraph(communityNavigator)
        guideNavGraph(guideNavigator)
        mypageNavGraph(mypageNavigator)
        loginNavGraph(authNavigator)
        signUpNavGraph(authNavigator)

    }
}
