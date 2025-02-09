package com.example.seollyongdan_frontend.presentation.traffic.screen

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import com.example.seollyongdan_frontend.presentation.traffic.navigation.TrafficNavigator
import com.example.seollyongdan_frontend.ui.theme.White
import com.google.accompanist.systemuicontroller.rememberSystemUiController

@Composable
fun TrafficRoute(
    navigator: TrafficNavigator
) {
    val systemUiController = rememberSystemUiController()

    SideEffect {
        systemUiController.setStatusBarColor(
            color = White
        )
    }
    TrafficScreen()
}

@Composable
fun TrafficScreen() {
    Text("교통 화면입니다.")
}