package com.example.seollyongdan_frontend.presentation.community.screen

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FabPosition
import androidx.compose.material3.IconButton
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Tab
import androidx.compose.material3.TabRow
import androidx.compose.material3.TabRowDefaults.SecondaryIndicator
import androidx.compose.material3.TabRowDefaults.tabIndicatorOffset
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
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.seollyongdan_frontend.R
import com.example.seollyongdan_frontend.presentation.auth.screen.RegionSearchBottomSheet
import com.example.seollyongdan_frontend.presentation.auth.screen.RegionViewModel
import com.example.seollyongdan_frontend.presentation.community.navigation.CommunityNavigator
import com.example.seollyongdan_frontend.ui.component.CommunityFloatingButton
import com.example.seollyongdan_frontend.ui.theme.Gray50
import com.example.seollyongdan_frontend.ui.theme.Gray900
import com.example.seollyongdan_frontend.ui.theme.Info400
import com.example.seollyongdan_frontend.ui.theme.White
import com.example.seollyongdan_frontend.ui.theme.h2Bold
import com.example.seollyongdan_frontend.ui.theme.h3Semi
import com.example.seollyongdan_frontend.ui.theme.h5Semi
import com.google.accompanist.systemuicontroller.rememberSystemUiController
import kotlinx.coroutines.launch

@Composable
fun CommunityRoute(
    navigator: CommunityNavigator,
) {
    val systemUiController = rememberSystemUiController()
    val communityPostViewModel: CommunityPostViewModel = hiltViewModel()
    val regionViewModel: RegionViewModel = hiltViewModel()
    val district : String = "용산구 청파동1가" //사용자 동네 백엔드에서 받아오기

    SideEffect {
        systemUiController.setStatusBarColor(
            color = Color.White
        )
    }

    CommunityScreen(
        onSearchClick = { selectedRegion ->
            navigator.navigateToCommunitySearch(district = selectedRegion) },
        onBackClick = { navigator.navigateBack() },
        onDetailClick = { id, selectedRegion ->
            navigator.navigateToCommunityDetail(id= id, district= selectedRegion)},
        onWriteClick = { selectedRegion ->
            navigator.navigateToCommunityWrite(district=selectedRegion)},
        onReviewClick = { selectedRegion ->
            navigator.navigateToCommunityReveiw(district = selectedRegion)},
        communityPostViewModel = communityPostViewModel,
        regionViewModel = regionViewModel,
        district = district
    )
}

@OptIn(ExperimentalMaterial3Api::class, ExperimentalFoundationApi::class)
@Composable
fun CommunityScreen(
    onSearchClick: (String) -> Unit,
    onBackClick: () -> Unit,
    onDetailClick: (Long, String) -> Unit,
    onWriteClick: (String) -> Unit,
    onReviewClick: (String) -> Unit,
    communityPostViewModel: CommunityPostViewModel,
    regionViewModel: RegionViewModel,
    district: String
) {
    val bottomSheetState = rememberModalBottomSheetState()
    var selectedRegion by remember { mutableStateOf(district) }
    var isBottomSheetVisible by remember { mutableStateOf(false) }
    val regions by regionViewModel.regions.collectAsState()

    val tabs = listOf("최신글", "인기글")
    val pagerState = rememberPagerState { tabs.size }
    val coroutineScope = rememberCoroutineScope()

    val formattedDistricts = remember(regions) {
        regions.filter { it.city == "서울특별시" } // city가 "서울특별시"인 데이터만 필터링
            .mapNotNull { region ->
                listOf(region.district, region.town) // district와 town만 포함
                    .filterNotNull()
                    .takeIf { it.isNotEmpty() }
                    ?.joinToString(" ")
            }.distinct()
    }

    fun showBottomSheet() {
        coroutineScope.launch {
            bottomSheetState.show()
            bottomSheetState.expand()
        }
    }

    fun hideBottomSheet() {
        coroutineScope.launch { bottomSheetState.hide() }
    }

    val context = LocalContext.current

    LaunchedEffect(Unit) {
        regionViewModel.fetchRegions(page = 1, perPage = 1800)
    }

    Box(
        modifier = Modifier.fillMaxSize()
    ) {
        Scaffold(
            floatingActionButtonPosition = FabPosition.Center,

            topBar = {
                TopAppBar(
                    modifier = Modifier.background(White),
                    title = {
                        Text(selectedRegion, style = h3Semi)
                    },
                    navigationIcon = {
                        IconButton(onClick = {
                            isBottomSheetVisible = true
                            showBottomSheet()
                        }) {
                            Image(
                                painter = painterResource(id = R.drawable.ic_com_pin),
                                contentDescription = "districtSearch"
                            )
                        }
                    },
                    actions = {
                        IconButton(onClick = {onSearchClick(selectedRegion)}) {
                            Image(
                                painter = painterResource(id = R.drawable.ic_com_search),
                                contentDescription = "communitySearch",
                                modifier = Modifier.padding(end = 16.dp)
                            )
                        }
                    },
                    colors = TopAppBarDefaults.topAppBarColors(
                        containerColor = White
                    ),
                )
            },


            floatingActionButton = {
                CommunityFloatingButton(onWriteClick = {onWriteClick(selectedRegion)}, onReviewClick = {onReviewClick(selectedRegion)})
            },

            content = { paddingValues ->
                Box(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(paddingValues)
                ) {
                    Column {
                        TabRow(
                            selectedTabIndex = pagerState.currentPage,
                            indicator = { tabPositions ->
                                SecondaryIndicator(
                                    modifier = Modifier
                                        .tabIndicatorOffset(tabPositions[pagerState.currentPage])
                                        .width(199.dp)
                                        .height(3.dp),
                                    color = Info400
                                )
                            },
                            containerColor = Color.White,
                            contentColor = Gray900,
                            modifier = Modifier
                                .fillMaxWidth()
                                .height(55.dp)
                        ) {
                            tabs.forEachIndexed { index, title ->
                                Tab(
                                    text = {
                                        Text(title, style = h5Semi, color = Gray900)
                                    },
                                    selected = pagerState.currentPage == index,
                                    modifier = Modifier.height(52.dp),
                                    onClick = {
                                        coroutineScope.launch {
                                            pagerState.animateScrollToPage(index)
                                        }
                                    }
                                )

                            }
                        }

                        HorizontalPager(
                            state = pagerState
                        ) { page ->

                            Column(
                                modifier = Modifier
                                    .fillMaxSize()
                                    .background(Gray50),
                            ) {
                                when (page) {
                                    0 -> CommunityLatestScreen(
                                        onDetailClick = {id -> onDetailClick(id, selectedRegion)},
                                        communityPostViewModel,
                                        selectedRegion
                                    )

                                    1 -> CommunityPopularScreen(
                                        onDetailClick = {id -> onDetailClick(id, selectedRegion)},
                                        communityPostViewModel,
                                        selectedRegion
                                    )
                                }
                            }

                        }


                    }


                }
                if (isBottomSheetVisible) {
                    ModalBottomSheet(
                        onDismissRequest = {
                            hideBottomSheet()
                            isBottomSheetVisible = false
                        },
                        sheetState = bottomSheetState
                    ) {
                        RegionSearchBottomSheet(
                            onDismiss = {
                                hideBottomSheet()
                                isBottomSheetVisible = false
                            },
                            onItemSelected = { address ->
                                selectedRegion = address
                                hideBottomSheet()
                                isBottomSheetVisible = false
                            },
                            regions = formattedDistricts, // 예제 데이터
                            sheetState = bottomSheetState
                        )
                    }
                }

            }
        )

    }
}

@Preview
@Composable
fun CommunityScreenPreview() {
    CommunityScreen(
        onSearchClick = {},
        onBackClick = {},
        onDetailClick = {a,b -> },
        onWriteClick = {},
        onReviewClick = {},
        communityPostViewModel = viewModel(),
        regionViewModel = viewModel(),
        district = "성북구"
    )
}