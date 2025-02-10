package com.example.seollyongdan_frontend.presentation.home.screen

import androidx.compose.runtime.Composable


@Composable
fun BottomSheetSwitcher(
    screen: BottomSheetScreen,
    homeViewModel: HomeViewModel,
    onSearchClick : () -> Unit
){
    when (screen){
        BottomSheetScreen.HOME -> BottomSheetMainScreen(homeViewModel, onSearchClick)
        BottomSheetScreen.SAFETY -> BottomSheetSafetyScreen(homeViewModel)
        BottomSheetScreen.REAL_ESTATE -> BottomSheetRealEstateScreen(homeViewModel)
        BottomSheetScreen.TRAFFIC -> BottomSheetTrafficScreen(homeViewModel)
        BottomSheetScreen.LIFE -> BottomSheetLifeScreen(homeViewModel)
        BottomSheetScreen.REVIEW -> BottomSheetReviewScreen(homeViewModel)
    }
}