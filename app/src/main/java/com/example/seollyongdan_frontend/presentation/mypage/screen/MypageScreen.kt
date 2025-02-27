package com.example.seollyongdan_frontend.presentation.mypage.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
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
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.seollyongdan_frontend.R
import com.example.seollyongdan_frontend.data.dto.response.ResponseUserDto
import com.example.seollyongdan_frontend.presentation.mypage.navigation.MypageNavigator
import com.example.seollyongdan_frontend.ui.component.AuthButton
import com.example.seollyongdan_frontend.ui.theme.h1Bold
import com.google.accompanist.systemuicontroller.rememberSystemUiController

@Composable
fun MypageRoute(
    navigator: MypageNavigator,
){
    val systemUiController = rememberSystemUiController()
    val mypageViewModel : MypageViewModel = hiltViewModel()

    SideEffect {
        systemUiController.setStatusBarColor(
            color = Color.White
        )
    }

    MypageScreen(onLogoutClick = {navigator.navigateLogin()},
        mypageViewModel = mypageViewModel)
}

@Composable
fun MypageScreen(
    onLogoutClick : () -> Unit,
    mypageViewModel: MypageViewModel
){

    Column (
        modifier = Modifier
            .fillMaxSize()
            .padding(15.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ){
        Spacer(modifier = Modifier.height(160.dp))

        Text("프로필", style = h1Bold)

        Spacer(modifier = Modifier.height(30.dp))


        Image(
            painter = painterResource(id = R.drawable.ic_home),
            contentDescription = "icon",
            modifier = Modifier
                .size(157.dp)
        )

        Spacer(modifier = Modifier.weight(1f))

        AuthButton(
            value = "로그아웃",
            onClick = {
            mypageViewModel.removeToken()
            onLogoutClick()
            })

        Spacer(modifier = Modifier.height(30.dp))


    }
}

@Preview
@Composable
fun MypageScreenPreview(){

    MypageScreen(onLogoutClick = {}, mypageViewModel = viewModel())
}