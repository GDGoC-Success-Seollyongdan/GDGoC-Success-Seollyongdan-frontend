package com.example.seollyongdan_frontend.presentation.review.screen

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import com.example.seollyongdan_frontend.presentation.review.navigation.ReviewNavigator
import com.example.seollyongdan_frontend.ui.theme.White
import com.google.accompanist.systemuicontroller.rememberSystemUiController

@Composable
fun ReviewRoute(
    navigator: ReviewNavigator
) {
    val systemUiController = rememberSystemUiController()

    SideEffect {
        systemUiController.setStatusBarColor(
            color = White
        )
    }
    ReviewScreen()
}

@Composable
fun ReviewScreen() {
    Text("리뷰 화면입니다.")
}