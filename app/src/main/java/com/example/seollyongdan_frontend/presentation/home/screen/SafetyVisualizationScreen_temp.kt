package com.example.seollyongdan_frontend.presentation.home.screen

import android.util.Log
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
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
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
import com.example.seollyongdan_frontend.ui.component.VisualizationState
import com.example.seollyongdan_frontend.ui.theme.Success900
import com.example.seollyongdan_frontend.ui.theme.White
import com.example.seollyongdan_frontend.ui.theme.h3Semi
import com.google.accompanist.systemuicontroller.rememberSystemUiController
import com.naver.maps.geometry.LatLng
import com.naver.maps.map.CameraPosition
import com.naver.maps.map.NaverMap
import com.naver.maps.map.compose.ExperimentalNaverMapApi
import com.naver.maps.map.compose.NaverMap
import com.naver.maps.map.compose.rememberCameraPositionState


@Composable
fun SafetyVisualizationTempRoute(
    navigator: HomeNavigator
) {
    val systemUiController = rememberSystemUiController()
    val safetyVisualizationViewModel : SafetyVisualizationViewModel = hiltViewModel()

    SideEffect {
        systemUiController.setStatusBarColor(
            color = Color.White
        )
    }

    SafetyVisualizationScreen_temp(
        onBackClick = { navigator.navigateBack() },
        safetyVisualizationViewModel = safetyVisualizationViewModel
    )
}


// 메인 화면 Composable
@OptIn(ExperimentalMaterial3Api::class, ExperimentalNaverMapApi::class)
@Composable
fun SafetyVisualizationScreen_temp(
    onBackClick: () -> Unit,
    safetyVisualizationViewModel : SafetyVisualizationViewModel
) {
    val context = LocalContext.current

    LaunchedEffect(Unit) {
        safetyVisualizationViewModel.getCrimeFreq()
    }

    // '높음', '낮음', '기타' 인덱스를 가져오기
    val highCrimeIndexes = safetyVisualizationViewModel.highCrimeIndexes
    val lowCrimeIndexes = safetyVisualizationViewModel.lowCrimeIndexes
    val otherCrimeIndexes = safetyVisualizationViewModel.otherCrimeIndexes


    Box(modifier = Modifier.fillMaxSize()) {
        Scaffold(
            topBar = {
                TopAppBar(
                    title = {
                        Text(
                            text = "범죄 발생 빈도",
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
                    text = "서울시 구별 범죄 발생 빈도"
                )

                Spacer(modifier = Modifier.height(25.dp))

                Column {
                    CrimeBox(highCrimeIndexes, "높음")

                    Spacer(modifier = Modifier.height(5.dp))

                    CrimeBox(otherCrimeIndexes, "보통")

                    Spacer(modifier = Modifier.height(5.dp))

                    CrimeBox(lowCrimeIndexes, "낮음")


                }



            }


        }
    }


}



@Preview
@Composable
fun SafetyVisualizationScreenTemPreview() {

    val safetyData = listOf(
        "high", "low", "average", "high",
        "low", "average", "high", "low",
        "average", "high", "low", "average",
        "high", "low", "average", "high",
        "low", "average", "high", "low",
        "average", "high", "low", "average",
        "high"
    )

    SafetyVisualizationScreen_temp(
        onBackClick = {},
        safetyVisualizationViewModel = viewModel()
    )
}