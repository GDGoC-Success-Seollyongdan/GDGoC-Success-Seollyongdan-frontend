package com.example.seollyongdan_frontend.presentation.home.screen

import androidx.compose.runtime.Composable


@Composable
fun BottomSheetSwitcher(
    screen: BottomSheetScreen,
    homeViewModel: HomeViewModel,
    onSearchClick : () -> Unit,
    onTrafficVisualizationClick : () -> Unit,
    onSafetyVisualizationClick : () -> Unit,
    districtName : String
){
    when (screen){
        BottomSheetScreen.HOME -> BottomSheetMainScreen(homeViewModel, onSearchClick)
        BottomSheetScreen.SAFETY -> BottomSheetSafetyScreen(homeViewModel, districtName)
        BottomSheetScreen.REAL_ESTATE -> BottomSheetRealEstateScreen(homeViewModel, districtName)
        BottomSheetScreen.TRAFFIC -> BottomSheetTrafficScreen(homeViewModel)
        BottomSheetScreen.LIFE -> BottomSheetLifeScreen(homeViewModel, districtName)
        BottomSheetScreen.REVIEW -> BottomSheetReviewScreen(homeViewModel, districtName)
        BottomSheetScreen.SAFETY -> BottomSheetSafetyScreen(homeViewModel, districtName, onSafetyVisualizationClick)
        BottomSheetScreen.REAL_ESTATE -> BottomSheetRealEstateScreen(homeViewModel)
        BottomSheetScreen.TRAFFIC -> BottomSheetTrafficScreen(homeViewModel, districtName, onTrafficVisualizationClick)
        BottomSheetScreen.LIFE -> BottomSheetLifeScreen(homeViewModel)
        BottomSheetScreen.REVIEW -> BottomSheetReviewScreen(homeViewModel)
    }
}