package com.example.seollyongdan_frontend.presentation.home.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.BottomSheetDefaults
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.IconButton
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.SideEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.seollyongdan_frontend.R
import com.example.seollyongdan_frontend.presentation.home.navigation.HomeNavigator
import com.example.seollyongdan_frontend.ui.theme.Success800
import com.example.seollyongdan_frontend.ui.theme.Success900
import com.example.seollyongdan_frontend.ui.theme.White
import com.example.seollyongdan_frontend.ui.theme.b1Semi
import com.example.seollyongdan_frontend.ui.theme.h3Semi
import com.google.accompanist.systemuicontroller.rememberSystemUiController
import com.naver.maps.geometry.LatLng
import com.naver.maps.map.CameraPosition
import com.naver.maps.map.CameraUpdate
import com.naver.maps.map.compose.ExperimentalNaverMapApi
import com.naver.maps.map.compose.NaverMap
import com.naver.maps.map.compose.rememberCameraPositionState
import kotlinx.coroutines.launch

@Composable
fun HomeRoute(
    navigator: HomeNavigator
) {
    val systemUiController = rememberSystemUiController()
    val homeViewModel: HomeViewModel = hiltViewModel()
    val safetyViewModel: SafetyViewModel = hiltViewModel()
    val trafficViewModel : TrafficViewModel = hiltViewModel()


    SideEffect {
        systemUiController.setStatusBarColor(
            color = Color.White
        )
    }

    HomeScreen(
        homeViewModel = homeViewModel,
        safetyViewModel = safetyViewModel,
        trafficViewModel = trafficViewModel,
        onSearchClick = { navigator.navigateToSearch() },
        onTrafficVisualizationClick = { navigator.navigateToTrafficVisualizationTemp() },
        onSafetyVisualizationClick = { navigator.navigateToSafetyVisualizationTemp() }
    )
}

@OptIn(ExperimentalMaterial3Api::class, ExperimentalNaverMapApi::class)
@Composable
fun HomeScreen(
    homeViewModel: HomeViewModel,
    safetyViewModel: SafetyViewModel,
    trafficViewModel: TrafficViewModel,
    onSearchClick: () -> Unit,
    onTrafficVisualizationClick: () -> Unit,
    onSafetyVisualizationClick: () -> Unit
) {
    val sheetState = rememberModalBottomSheetState(skipPartiallyExpanded = false)
    val coroutineScope = rememberCoroutineScope()
    var showBottomSheet by remember { mutableStateOf(true) }
    val bottomSheetScreen by homeViewModel.bottomSheetScreen.collectAsState()
    var showBottomSheetSearch by remember { mutableStateOf(false) }
    val cameraPositionState = rememberCameraPositionState {
        position = CameraPosition(LatLng(37.5663, 126.9779), 13.0)
    }

    val district = homeViewModel.userData.district.split(" ")[0]

    var districtName by remember { mutableStateOf(district) }

    // districtName이 변경될 때 바텀시트 새로 호출
    LaunchedEffect(districtName) {
        showBottomSheet = true
        sheetState.show()
    }


    Box(
        modifier = Modifier.fillMaxSize()
    ) {
        Scaffold(
            topBar = {
                TopAppBar(
                    modifier = Modifier.background(White),
                    title = {
                        Text(
                            text = districtName,
                            style = h3Semi,
                            color = Success800
                        )
                    },
                    colors = TopAppBarDefaults.centerAlignedTopAppBarColors(
                        containerColor = White
                    ),
                    actions = {
                        IconButton(onClick = { showBottomSheetSearch = true }) {
                            Image(
                                painter = painterResource(id = R.drawable.ic_home_search),
                                contentDescription = "search Image",
                                modifier = Modifier.padding(end = 16.dp)
                            )
                        }
                    }
                )
            },
            content = { paddingValues ->
                Box(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(paddingValues)
                ) {
                    NaverMap(
                        modifier = Modifier.fillMaxSize(),
                        cameraPositionState = cameraPositionState
                    )

                    // 바텀시트가 숨겨져 있을 때만 버튼 표시
                    if (!showBottomSheet) {
                        Button(
                            onClick = { showBottomSheet = true },
                            modifier = Modifier
                                .align(Alignment.BottomCenter)
                                .padding(bottom = 16.dp)
                                .navigationBarsPadding(),
                            colors = ButtonDefaults.buttonColors(
                                containerColor = Success900
                            ),
                            shape = RoundedCornerShape(20.dp)
                        ) {
                            Text(
                                text = "상세 정보 보기",
                                style = b1Semi,
                                color = White
                            )
                        }
                    }
                }
            }
        )

        if (showBottomSheet) {
            ModalBottomSheet(
                onDismissRequest = { showBottomSheet = false },
                sheetState = sheetState,
                dragHandle = { BottomSheetDefaults.DragHandle() },
                windowInsets = WindowInsets(0),
                containerColor = White
            ) {
                Box(
                    modifier = Modifier
                        .navigationBarsPadding()
                ) {
                    BottomSheetSwitcher(
                        bottomSheetScreen,
                        homeViewModel,
                        safetyViewModel,
                        trafficViewModel,
                        onSearchClick,
                        onTrafficVisualizationClick,
                        onSafetyVisualizationClick,
                        districtName
                    )
                }
            }
        }
        if (showBottomSheetSearch) {
            BottomSheetSearch(
                onDismiss = { showBottomSheetSearch = false },
                onMoveCamera = { location ->
                    coroutineScope.launch {
                        cameraPositionState.move(CameraUpdate.scrollTo(location))
                    }
                }, onSelectDistrict = { selectedDistrict ->
                    districtName = selectedDistrict
                    showBottomSheet = true // 동네가 바뀔 때 바텀시트 새로 호출
                    showBottomSheetSearch = false
                }
            )
        }
    }
}


