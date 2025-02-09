package com.example.seollyongdan_frontend.presentation.home.screen

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.SideEffect
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
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
import com.example.seollyongdan_frontend.ui.theme.h3Semi
import com.example.seollyongdan_frontend.ui.theme.h5Bold
import com.example.seollyongdan_frontend.ui.theme.h5Semi
import com.example.seollyongdan_frontend.ui.theme.h7Regular
import com.google.accompanist.systemuicontroller.rememberSystemUiController
import com.naver.maps.map.compose.ExperimentalNaverMapApi
import com.naver.maps.map.compose.NaverMap
import kotlinx.coroutines.launch

@Composable
fun HomeRoute(
    navigator: HomeNavigator
){
    val systemUiController = rememberSystemUiController()

    SideEffect {
        systemUiController.setStatusBarColor(
            color = Color.White
        )
    }

    HomeScreen(
        onClickToSafety = { navigator.navigateToSafety() },
        onClickToRealEstate = { navigator.navigateToRealEstate() },
        onClickToTraffic = { navigator.navigateToTraffic() },
        onClickToLife = { navigator.navigateToLife() },
        onClickToReview = { navigator.navigateToReview() },
        onClickToSearch = { navigator.navigateToSearch() }
    )
}

@OptIn(ExperimentalMaterial3Api::class, ExperimentalNaverMapApi::class)
@Composable
fun HomeScreen(
    onClickToSafety : () -> Unit,
    onClickToRealEstate : () -> Unit,
    onClickToTraffic : () -> Unit,
    onClickToLife : () -> Unit,
    onClickToReview : () -> Unit,
    onClickToSearch: () -> Unit
){
    val sheetState = rememberModalBottomSheetState(skipPartiallyExpanded = true)
    val coroutineScope = rememberCoroutineScope()

    LaunchedEffect(Unit) {
        coroutineScope.launch {
            sheetState.show()
        }
    }
    Scaffold(
        topBar = {
            TopAppBar(
                modifier = Modifier.background(White),
                title = {
                    Text(
                        //FIXME 회원가입 시 설정한 동네 받아오도록
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
                    modifier = Modifier
                        .fillMaxSize()
                )
            }
        }
    )

    ModalBottomSheet(
        onDismissRequest = { coroutineScope.launch { sheetState.hide() }},
        sheetState = sheetState,
        containerColor = White
    ) {
        Column(

        ) {
            BottomSheetContent(
                onClickToSafety = onClickToSafety,
                onClickToRealEstate = onClickToRealEstate,
                onClickToTraffic = onClickToTraffic,
                onClickToLife = onClickToLife,
                onClickToReview = onClickToReview,
                onClickToSearch = onClickToSearch
            )
        }
    }
}

@Composable
fun BottomSheetContent(
    onClickToSafety: () -> Unit,
    onClickToRealEstate: () -> Unit,
    onClickToTraffic: () -> Unit,
    onClickToLife: () -> Unit,
    onClickToReview: () -> Unit,
    onClickToSearch: () -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .height(670.dp)
            .background(color = White)
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(17.dp)
    ) {
        Row(

        ) {
            Text(
                //FIXME 설정한 구 받아오기
                "성북구 ",
                color = Success800,
                style = h5Bold
            )
            Text(
                "상세 정보",
                color = Gray900,
                style = h5Bold
            )
        }
        HomeButton(
            imageId = R.drawable.ic_home_lock,
            value1 = "범죄 발생 및 빈도를 알고 싶다면",
            value2 = "안전 및 치안",
            onClick = onClickToSafety
        )
        HomeButton(
            imageId = R.drawable.ic_home_realestate,
            value1 = "전월세가 정보를 알고 싶다면",
            value2 = "부동산",
            onClick = onClickToRealEstate
        )
        HomeButton(
            imageId = R.drawable.ic_home_traffic,
            value1 = "교통 혼잡도를 알고 싶다면",
            value2 = "교통",
            onClick = onClickToTraffic
        )
        HomeButton(
            imageId = R.drawable.ic_home_life,
            value1 = "문화시설 및 상권 현황을 알고 싶다면",
            value2 = "생활/편의시설",
            onClick = onClickToLife
        )
        HomeButton(
            imageId = R.drawable.ic_home_review,
            value1 = "동네 사람들의 평가를 알고 싶다면",
            value2 = "리뷰 및 별점",
            onClick = onClickToReview
        )
        Button(
            modifier = Modifier
                .fillMaxWidth()
                .height(87.dp),
            shape = RoundedCornerShape(15.dp),
            onClick = onClickToSearch,
            colors = ButtonDefaults.buttonColors(Success500)
        ) {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    "서울시 사랑방에서만 제공하는",
                    color = Gray500,
                    style = h7Regular
                )
                Text(
                    "나한테 딱 맞는 동네 골라보기",
                    color = Success900,
                    style = h5Semi
                )
            }
        }
    }
}

@Preview
@Composable
fun HomeScreenPreview() {
    SeollyongdanfrontendTheme {
        HomeScreen(
            onClickToSafety = {},
            onClickToRealEstate = {},
            onClickToTraffic = {},
            onClickToLife = {},
            onClickToReview = {},
            onClickToSearch = {}
        )
    }
}

@Preview
@Composable
fun BottomSheetPreview() {
    BottomSheetContent(
        onClickToSafety = {},
        onClickToTraffic = {},
        onClickToRealEstate = {},
        onClickToLife = {},
        onClickToReview = {},
        onClickToSearch = {}
    )
}
