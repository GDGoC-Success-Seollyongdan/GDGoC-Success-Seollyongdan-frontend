package com.example.seollyongdan_frontend.presentation.realestate.screen

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import com.example.seollyongdan_frontend.presentation.realestate.navigation.RealEstateNavigator
import com.example.seollyongdan_frontend.ui.theme.White
import com.google.accompanist.systemuicontroller.rememberSystemUiController

@Composable
fun RealEstateRoute(
    navigator : RealEstateNavigator
) {
    val systemUiController = rememberSystemUiController()

    SideEffect {
        systemUiController.setStatusBarColor(
            color = White
        )
    }
    RealEstateScreen()
}

@Composable
fun RealEstateScreen() {
    Text("부동산 화면입니다.")
}