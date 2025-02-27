package com.example.seollyongdan_frontend.presentation.auth.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.seollyongdan_frontend.R
import com.example.seollyongdan_frontend.ui.theme.Info500
import com.example.seollyongdan_frontend.ui.theme.White
import com.example.seollyongdan_frontend.ui.theme.h1Bold
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

    Column (
        modifier = Modifier
            .fillMaxSize()
            .background(Info500),
        horizontalAlignment = Alignment.CenterHorizontally
    ){
        Spacer(modifier = Modifier.height(160.dp))

        Text("서울시\n사랑방", style = h1Bold, color = White)

        Spacer(modifier = Modifier.height(60.dp))


        Image(
            painter = painterResource(id = R.drawable.ic_home),
            contentDescription = "icon",
            modifier = Modifier
                .size(157.dp)
        )

    }
}

@Preview(showBackground = true)
@Composable
fun SplashPreview() {
    SplashScreen(
        navController = rememberNavController(),
        modifier = Modifier.fillMaxSize()
    )
}