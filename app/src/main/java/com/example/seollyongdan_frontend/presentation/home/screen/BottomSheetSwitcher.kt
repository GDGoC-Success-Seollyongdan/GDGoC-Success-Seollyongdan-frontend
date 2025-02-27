package com.example.seollyongdan_frontend.presentation.home.screen

import androidx.compose.runtime.Composable


@Composable
fun BottomSheetSwitcher(
    screen: BottomSheetScreen,
    homeViewModel: HomeViewModel,
    safetyViewModel: SafetyViewModel,
    trafficViewModel: TrafficViewModel,
    realEstateViewModel: RealEstateViewModel,
    lifeViewModel: LifeViewModel,
    onSearchClick : () -> Unit,
    onTrafficVisualizationClick : () -> Unit,
    onSafetyVisualizationClick : () -> Unit,
    districtName : String
){
    when (screen){
        BottomSheetScreen.HOME -> BottomSheetMainScreen(homeViewModel, onSearchClick,districtName)
        BottomSheetScreen.REAL_ESTATE -> BottomSheetRealEstateScreen(homeViewModel, realEstateViewModel, districtName)
        BottomSheetScreen.LIFE -> BottomSheetLifeScreen(homeViewModel, lifeViewModel, districtName)
        BottomSheetScreen.REVIEW -> BottomSheetReviewScreen(homeViewModel, districtName)
        BottomSheetScreen.SAFETY -> BottomSheetSafetyScreen(homeViewModel, safetyViewModel, districtName, onSafetyVisualizationClick)
        BottomSheetScreen.TRAFFIC -> BottomSheetTrafficScreen(homeViewModel, trafficViewModel, districtName, onTrafficVisualizationClick)
    }
}