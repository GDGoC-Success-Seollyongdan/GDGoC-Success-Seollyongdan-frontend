package com.example.seollyongdan_frontend.presentation.auth.screen

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import kotlinx.coroutines.delay

@Composable
fun SplashScreen(navController: NavController, modifier: Modifier = Modifier){

    LaunchedEffect(Unit) {
        delay(2500) // 2.5초 대기
        navController.navigate("login") { // main 화면으로 이동
            popUpTo("splash") {
                inclusive = true
            }
            launchSingleTop = true
        }
    }




    Text("스플래시 화면입니다")
}