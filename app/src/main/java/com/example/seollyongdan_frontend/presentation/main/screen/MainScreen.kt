package com.example.seollyongdan_frontend.presentation.main.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.material.ripple.LocalRippleTheme
import androidx.compose.material.ripple.RippleAlpha
import androidx.compose.material.ripple.RippleTheme
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Color.Companion.White
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.seollyongdan_frontend.R
import com.example.seollyongdan_frontend.ui.component.BottomNavigationItem
import com.example.seollyongdan_frontend.presentation.community.navigation.CommunityNavigator
import com.example.seollyongdan_frontend.presentation.community.screen.CommunityRoute
import com.example.seollyongdan_frontend.presentation.guide.navigation.GuideNavigator
import com.example.seollyongdan_frontend.presentation.guide.screen.GuideRoute
import com.example.seollyongdan_frontend.presentation.home.navigation.HomeNavigator
import com.example.seollyongdan_frontend.presentation.home.screen.HomeRoute
import com.example.seollyongdan_frontend.presentation.main.navigation.MainNavigator
import com.example.seollyongdan_frontend.presentation.mypage.navigation.MypageNavigator
import com.example.seollyongdan_frontend.presentation.mypage.screen.MypageRoute
import com.example.seollyongdan_frontend.presentation.search.navigation.SearchNavigator
import com.example.seollyongdan_frontend.presentation.search.screen.SearchRoute
import com.example.seollyongdan_frontend.ui.theme.SeollyongdanfrontendTheme

@Composable
fun MainRoute(
    navigator: MainNavigator,
) {
    MainScreen(
        navController = navigator.navController,
    )
}

@Composable
fun MainScreen(
    navController: NavHostController,
) {
    var selectedItem by rememberSaveable { mutableIntStateOf(0) }
    val items = listOf(
        BottomNavigationItem(
            selectedIcon = ImageVector.vectorResource(id = R.drawable.ic_nav_home,),
            unselectedIcon = ImageVector.vectorResource(id = R.drawable.ic_nav_home_unselected),
            label = "홈"
        ),
        BottomNavigationItem(
            selectedIcon = ImageVector.vectorResource(id = R.drawable.ic_nav_search),
            unselectedIcon = ImageVector.vectorResource(id = R.drawable.ic_nav_search_unselected),
            label = "검색"
        ),
        BottomNavigationItem(
            selectedIcon = ImageVector.vectorResource(id = R.drawable.ic_nav_comm),
            unselectedIcon = ImageVector.vectorResource(id = R.drawable.ic_nav_comm_unselected),
            label = "커뮤니티"
        ),
        BottomNavigationItem(
            selectedIcon = ImageVector.vectorResource(id = R.drawable.ic_nav_guide),
            unselectedIcon = ImageVector.vectorResource(id = R.drawable.ic_nav_guide_unselected),
            label = "가이드북"
        ),
        BottomNavigationItem(
            selectedIcon = ImageVector.vectorResource(id = R.drawable.ic_nav_setting),
            unselectedIcon = ImageVector.vectorResource(id = R.drawable.ic_nav_setting_unselected),
            label = "마이페이지"
        )

    )

    Scaffold(
        bottomBar = {
            NavigationBar(
                modifier = Modifier.background(White),
                containerColor = White
            ) {
                items.forEachIndexed { index, item ->
                    CompositionLocalProvider(LocalRippleTheme provides NoRippleTheme) {
                        NavigationBarItem(
                            icon = {
                                Icon(
                                    imageVector = if (selectedItem == index) item.selectedIcon else item.unselectedIcon,
                                    contentDescription = null,
                                    tint = Color.Unspecified
                                )
                            },
                            selected = selectedItem == index,
                            onClick = { selectedItem = index },
                            colors = NavigationBarItemDefaults.colors(
                                indicatorColor = White
                            ),
                        )
                    }
                }
            }
        }
    ) { innerPadding ->
        Box(modifier = Modifier.padding(innerPadding)) {
            when (selectedItem) {
                0 -> {
                    HomeRoute(navigator = HomeNavigator(navController = navController))
                }
                1 -> {
                    SearchRoute(navigator = SearchNavigator(navController = navController))
                }
                2 -> {
                    CommunityRoute(navigator = CommunityNavigator(navController = navController))
                }
                3 -> {
                    GuideRoute(navigator = GuideNavigator(navController = navController))
                }
                4 -> {
                    MypageRoute(navigator = MypageNavigator(navController = navController))
                }
            }
        }

    }
}

private object NoRippleTheme : RippleTheme {
    @Composable
    override fun defaultColor() = Color.Unspecified

    @Composable
    override fun rippleAlpha(): RippleAlpha {
        return RippleAlpha(0.0f, 0.0f, 0.0f, 0.0f)
    }
}

@Preview
@Composable
fun MainScreenPreview() {
    SeollyongdanfrontendTheme  {
        MainScreen(
            navController = rememberNavController()
        )
    }
}