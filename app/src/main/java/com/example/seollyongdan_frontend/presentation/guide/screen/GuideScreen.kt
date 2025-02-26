package com.example.seollyongdan_frontend.presentation.guide.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.seollyongdan_frontend.R
import com.example.seollyongdan_frontend.presentation.guide.navigation.GuideNavigator
import com.example.seollyongdan_frontend.ui.theme.h1Bold
import com.google.accompanist.systemuicontroller.rememberSystemUiController

@Composable
fun GuideRoute(
    navigator: GuideNavigator,
){
    val systemUiController = rememberSystemUiController()

    SideEffect {
        systemUiController.setStatusBarColor(
            color = Color.White
        )
    }

    GuideScreen()
}

@Composable
fun GuideScreen(){

    Column (
        modifier = Modifier
            .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally
    ){
        Spacer(modifier = Modifier.height(160.dp))

        Text("부동산 가이드북", style = h1Bold)

        Spacer(modifier = Modifier.height(30.dp))


        Image(
            painter = painterResource(id = R.drawable.ic_home),
            contentDescription = "icon",
            modifier = Modifier
                .size(157.dp)
        )

    }
}

@Preview
@Composable
fun GuideScreenPreview(){

    GuideScreen()
}