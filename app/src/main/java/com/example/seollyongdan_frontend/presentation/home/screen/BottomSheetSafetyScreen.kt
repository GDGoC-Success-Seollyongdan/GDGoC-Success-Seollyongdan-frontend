package com.example.seollyongdan_frontend.presentation.home.screen

import androidx.compose.runtime.Composable
import com.example.seollyongdan_frontend.R
import com.example.seollyongdan_frontend.ui.component.HomeButton

@Composable
fun BottomSheetSafetyScreen(
    homeViewModel: HomeViewModel,
) {
    HomeButton(
        imageId = R.drawable.ic_home_lock,
        value1 = "이전 페이지로 돌아가기",
        value2 = "안전 및 치안",
        onClick = { homeViewModel.setBottomSheetScreen(BottomSheetScreen.HOME) }
    )
}