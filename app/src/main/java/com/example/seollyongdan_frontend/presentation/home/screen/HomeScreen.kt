package com.example.seollyongdan_frontend.presentation.home.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.BottomSheetDefaults
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SheetValue
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
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.seollyongdan_frontend.R
import com.example.seollyongdan_frontend.presentation.home.navigation.HomeNavigator
import com.example.seollyongdan_frontend.ui.component.HomeButton
import com.example.seollyongdan_frontend.ui.theme.Gray500
import com.example.seollyongdan_frontend.ui.theme.Gray900
import com.example.seollyongdan_frontend.ui.theme.SeollyongdanfrontendTheme
import com.example.seollyongdan_frontend.ui.theme.Success500
import com.example.seollyongdan_frontend.ui.theme.Success800
import com.example.seollyongdan_frontend.ui.theme.Success900
import com.example.seollyongdan_frontend.ui.theme.White
import com.example.seollyongdan_frontend.ui.theme.b1Regular
import com.example.seollyongdan_frontend.ui.theme.b2Regular
import com.example.seollyongdan_frontend.ui.theme.h3Semi
import com.example.seollyongdan_frontend.ui.theme.h5Bold
import com.example.seollyongdan_frontend.ui.theme.h5Semi
import com.example.seollyongdan_frontend.ui.theme.h7Regular
import com.google.accompanist.systemuicontroller.rememberSystemUiController
import com.naver.maps.map.compose.ExperimentalNaverMapApi
import com.naver.maps.map.compose.NaverMap

@Composable
fun HomeRoute(
    navigator: HomeNavigator
){
    val systemUiController = rememberSystemUiController()
    val homeViewModel : HomeViewModel = hiltViewModel()


    SideEffect {
        systemUiController.setStatusBarColor(
            color = Color.White
        )
    }

    HomeScreen(
        homeViewModel = homeViewModel,
        onSearchClick = {navigator.navigateToSearch()}
    )
}

@OptIn(ExperimentalMaterial3Api::class, ExperimentalNaverMapApi::class)
@Composable
fun HomeScreen(
    homeViewModel: HomeViewModel,
    onSearchClick : () -> Unit
){
    val sheetState = rememberModalBottomSheetState(skipPartiallyExpanded = false)
    val coroutineScope = rememberCoroutineScope()
    var showBottomSheet by remember { mutableStateOf(true) }
    val bottomSheetScreen by homeViewModel.bottomSheetScreen.collectAsState()


    LaunchedEffect(Unit) {
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
                            text = "성북구",
                            style = h3Semi,
                            color = Success800
                        )
                    },
                    colors = TopAppBarDefaults.centerAlignedTopAppBarColors(
                        containerColor = White
                    )
                )
            },
            content = { paddingValues ->
                Box(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(paddingValues)
                ) {
                    NaverMap(
                        modifier = Modifier.fillMaxSize()
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
                                containerColor = Success800
                            ),
                            shape = RoundedCornerShape(8.dp)
                        ) {
                            Text(
                                text = "상세 정보 보기",
                                style = b1Regular,
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
                    BottomSheetSwitcher(bottomSheetScreen, homeViewModel, onSearchClick)
                }
            }
        }
    }
}


