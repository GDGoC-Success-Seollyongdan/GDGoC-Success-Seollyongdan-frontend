package com.example.seollyongdan_frontend.presentation.home.screen

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.SideEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.seollyongdan_frontend.R
import com.example.seollyongdan_frontend.presentation.home.navigation.HomeNavigator
import com.example.seollyongdan_frontend.ui.component.CrimeBox
import com.example.seollyongdan_frontend.ui.component.MainToVisualizationButton
import com.example.seollyongdan_frontend.ui.theme.Success900
import com.example.seollyongdan_frontend.ui.theme.White
import com.example.seollyongdan_frontend.ui.theme.h3Semi
import com.google.accompanist.systemuicontroller.rememberSystemUiController
import com.naver.maps.map.compose.ExperimentalNaverMapApi


@Composable
fun TrafficVisualizationTempRoute(
    navigator: HomeNavigator
) {
    val systemUiController = rememberSystemUiController()
    val trafficVisualizationViewModel : TrafficVisualizationViewModel = hiltViewModel()

    SideEffect {
        systemUiController.setStatusBarColor(
            color = Color.White
        )
    }

    TrafficVisualizationScreen_temp(
        onBackClick = { navigator.navigateBack() },
        trafficVisualizationViewModel = trafficVisualizationViewModel
    )
}


// 메인 화면 Composable
@OptIn(ExperimentalMaterial3Api::class, ExperimentalNaverMapApi::class)
@Composable
fun TrafficVisualizationScreen_temp(
    onBackClick: () -> Unit,
    trafficVisualizationViewModel: TrafficVisualizationViewModel
) {
    val context = LocalContext.current

    //LaunchedEffect(Unit) {
    //    trafficVisualizationViewModel.getCongestion()
    //}

    //'높음', '낮음', '기타' 인덱스를 가져오기
    //val highCongestionIndexes by trafficVisualizationViewModel.highCongestionIndexes.collectAsState()
    //val lowCongestionIndexes by trafficVisualizationViewModel.lowCongestionIndexes.collectAsState()
    //val otherCongestionIndexes by trafficVisualizationViewModel.otherCongestionIndexes.collectAsState()

    val highCongestionIndexes = listOf(1,3,4,12,14,15,22,23,)
    val lowCongestionIndexes = listOf(5,7,9,10,11,13,18,19,20,)
    val otherCongestionIndexes = listOf(2,6,8,16,17,21,24,25)

    Box(modifier = Modifier.fillMaxSize()) {
        Scaffold(
            topBar = {
                TopAppBar(
                    title = {
                        Text(
                            text = "교통 혼잡도",
                            style = h3Semi,
                            color = Success900
                        )
                    },
                    navigationIcon = {
                        IconButton(
                            onClick =
                            onBackClick
                        ) {
                            Icon(
                                painter = painterResource(id = R.drawable.ic_back),
                                contentDescription = "Back"
                            )
                        }
                    },
                    colors = TopAppBarDefaults.topAppBarColors(
                        containerColor = White
                    )
                )
            }
        ) { paddingValues ->

            Column(
                modifier = Modifier
                    .padding(paddingValues)
                    .padding(top = 20.dp)
                    .padding(horizontal = 15.dp)
            ) {

                MainToVisualizationButton(
                    onClick = {},
                    text = "서울시 구별 교통 혼잡도"
                )

                Spacer(modifier = Modifier.height(25.dp))

                Column {
                    CrimeBox(highCongestionIndexes, "높음")

                    Spacer(modifier = Modifier.height(20.dp))

                    CrimeBox(otherCongestionIndexes, "보통")

                    Spacer(modifier = Modifier.height(20.dp))

                    CrimeBox(lowCongestionIndexes, "낮음")

                }



            }


        }
    }


}



@Preview
@Composable
fun TrafficVisualizationScreenTemPreview() {

    val safetyData = listOf(
        "high", "low", "average", "high",
        "low", "average", "high", "low",
        "average", "high", "low", "average",
        "high", "low", "average", "high",
        "low", "average", "high", "low",
        "average", "high", "low", "average",
        "high"
    )

    TrafficVisualizationScreen_temp(
        onBackClick = {},
        trafficVisualizationViewModel = viewModel()
    )
}