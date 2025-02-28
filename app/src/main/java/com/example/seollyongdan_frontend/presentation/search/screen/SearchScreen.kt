package com.example.seollyongdan_frontend.presentation.search.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.remember
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.seollyongdan_frontend.R
import com.example.seollyongdan_frontend.data.dto.response.ResponseUserDto
import com.example.seollyongdan_frontend.presentation.search.navigation.SearchNavigator
import com.example.seollyongdan_frontend.ui.component.DistrictGroupButton
import com.example.seollyongdan_frontend.ui.theme.Gray100
import com.example.seollyongdan_frontend.ui.theme.Gray300
import com.example.seollyongdan_frontend.ui.theme.Primary900
import com.example.seollyongdan_frontend.ui.theme.White
import com.example.seollyongdan_frontend.ui.theme.h3Semi
import com.example.seollyongdan_frontend.ui.theme.h5Semi
import com.example.seollyongdan_frontend.ui.theme.h7Semi
import com.google.accompanist.systemuicontroller.rememberSystemUiController

@Composable
fun SearchRoute(
    navigator: SearchNavigator,
){
    val systemUiController = rememberSystemUiController()
    val searchViewModel : SearchViewModel = hiltViewModel()

    SideEffect {
        systemUiController.setStatusBarColor(
            color = Color.White
        )
    }

    SearchScreen(
        onClickToSearchResult = { safety, traffic, real_estate , amenities ->
            navigator.navigateToSearchResult(safety, traffic, real_estate, amenities) },
        searchViewModel = searchViewModel
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SearchScreen(
    onClickToSearchResult: (String, String, String, String) -> Unit,
    searchViewModel: SearchViewModel
){
    val sheetState = rememberModalBottomSheetState()
    val coroutineScope = rememberCoroutineScope()
    var showBottomSheet = remember { mutableStateOf(false) }

    Scaffold (
        topBar = {
            TopAppBar(
                modifier = Modifier.background(White),
                title = {
                    Text(
                        "동네 추천 받기",
                        style = h3Semi,
                        color = Primary900
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
                Column(
                    modifier = Modifier
                        .padding(16.dp)
                ) {
                    Box(
                        modifier = Modifier
                            .fillMaxWidth()
                            .background(color = Gray100, shape = RoundedCornerShape(10.dp))
                            .padding(8.dp)
                            .clickable {
                                showBottomSheet.value = true
                            }
                    ) {
                        Row() {
                            Icon(
                                imageVector = Icons.Filled.Search,
                                contentDescription = "검색 이미지",
                                tint = Gray300
                            )
                            Text(
                                " 원하는 조건 설정하고 딱 맞는 지역구 찾기",
                                color = Gray300,
                                style = h7Semi
                            )
                        }
                    }

                    if (showBottomSheet.value) {
                        BottomSheetSearchFilter(
                            onDismiss = { showBottomSheet.value = false },
                            onClickToSearchResult = { safety, traffic, real_estate, amenities ->
                                onClickToSearchResult(safety, traffic, real_estate, amenities)},
                            searchViewModel = searchViewModel
                        )
                    }
                    Spacer(modifier = Modifier.height(45.dp))
                    Text(
                        "지역구 그룹 모아보기",
                        color = Primary900,
                        style = h5Semi
                    )
                    Spacer(modifier = Modifier.height(16.dp))
                    DistrictGroupButton(image = R.drawable.ic_search_wallet, text = "높은 물가, 높은 만족도", onClickToSearchResult = { })
                    Spacer(modifier = Modifier.height(8.dp))
                    DistrictGroupButton(image = R.drawable.ic_search_fire, text = "빠르고 효율적인 경제 중심지", onClickToSearchResult = {})
                    Spacer(modifier = Modifier.height(8.dp))
                    DistrictGroupButton(image = R.drawable.ic_search_cup, text = "안정적이고 조화로운 주거 환경", onClickToSearchResult = {})
                    Spacer(modifier = Modifier.height(8.dp))
                    DistrictGroupButton(image = R.drawable.ic_search_sun, text = "실속 있는 선택, 알뜰한 삶", onClickToSearchResult = {})
                    Spacer(modifier = Modifier.height(8.dp))
                    DistrictGroupButton(image = R.drawable.ic_search_puzzle, text = "협력하며 살아가는 삶", onClickToSearchResult = {})
                    Spacer(modifier = Modifier.height(8.dp))
                    DistrictGroupButton(image = R.drawable.ic_search_book, text = "느린 발전, 꾸준한 성장", onClickToSearchResult = {  })
                    Spacer(modifier = Modifier.height(8.dp))
                }
            }
        }
    )
}

