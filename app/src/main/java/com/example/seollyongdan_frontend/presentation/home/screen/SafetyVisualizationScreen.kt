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
import androidx.compose.runtime.SideEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.seollyongdan_frontend.R
import com.example.seollyongdan_frontend.presentation.home.navigation.HomeNavigator
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
fun SafetyVisualizationRoute(
    navigator: HomeNavigator
) {
    val systemUiController = rememberSystemUiController()

    SideEffect {
        systemUiController.setStatusBarColor(
            color = Color.White
        )
    }

    SafetyVisualizationScreen(
        onBackClick = { navigator.navigateBack() },
    )
}


// 메인 화면 Composable
@OptIn(ExperimentalMaterial3Api::class, ExperimentalNaverMapApi::class)
@Composable
fun SafetyVisualizationScreen(
    onBackClick: () -> Unit,
    safetyLevels: List<String> = listOf(
        "high", "low", "average", "high",
        "low", "average", "high", "low",
        "average", "high", "low", "average",
        "high", "low", "average", "high",
        "low", "average", "high", "low",
        "average", "high", "low", "average",
        "high"
    ) // 각 구별 혼잡도 현황 - 백엔드에서 받는 형태로 수정 필요
) {
    val context = LocalContext.current
    val naverMapState = remember { mutableStateOf<NaverMap?>(null) }
    Log.d("SafetyLevels", "Traffic levels: $safetyLevels")


    val geoJsonString = remember {
        context.assets.open("seoul_districts.geojson")
            .bufferedReader()
            .use { it.readText() }
    }

    // 서울시청 기준 카메라 위치
    val cameraPositionState = rememberCameraPositionState {
        position = CameraPosition(LatLng(37.5663, 126.9779), 11.0)
    }



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
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(paddingValues)
            ) {
                NaverMap(
                    modifier = Modifier.fillMaxSize(),
                    cameraPositionState = cameraPositionState,
                ) {
                    geoJsonString?.let { geoJson ->
                        Log.d("MapState", "NaverMap is ready")
                        naverMapState.value?.let { naverMap ->
                            DrawDistrictsOnMap(
                                geoJsonString = geoJson,
                                Levels = safetyLevels,
                                naverMap = naverMap
                            )
                        } ?: Log.d("MapState", "NaverMap is not ready")
                    }


                }



            }

            Column(
                modifier = Modifier
                    .padding(top = 90.dp, start = 15.dp)
            ) {

                MainToVisualizationButton(
                    onClick = {},
                    text = "서울시 구별 범죄 발생 빈도"
                )

                Spacer(modifier = Modifier.height(5.dp))

                VisualizationState(
                    text1 = "적은 편이에요",
                    text2 = "보통이에요",
                    text3 = "많은 편이에요"
                )

            }


        }
    }
}



@Preview
@Composable
fun SafetyVisualizationScreenPreview() {

    val safetyData = listOf(
        "high", "low", "average", "high",
        "low", "average", "high", "low",
        "average", "high", "low", "average",
        "high", "low", "average", "high",
        "low", "average", "high", "low",
        "average", "high", "low", "average",
        "high"
    )

    SafetyVisualizationScreen(
        safetyLevels = safetyData,
        onBackClick = {}
    )
}