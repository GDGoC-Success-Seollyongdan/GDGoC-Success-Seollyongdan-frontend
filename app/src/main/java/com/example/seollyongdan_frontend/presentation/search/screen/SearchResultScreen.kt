package com.example.seollyongdan_frontend.presentation.search.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.SideEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.example.seollyongdan_frontend.R
import com.example.seollyongdan_frontend.presentation.main.screen.MainViewModel
import com.example.seollyongdan_frontend.presentation.search.navigation.SearchNavigator
import com.example.seollyongdan_frontend.ui.component.DistrictButton
import com.example.seollyongdan_frontend.ui.theme.Gray50
import com.example.seollyongdan_frontend.ui.theme.Primary900
import com.example.seollyongdan_frontend.ui.theme.White
import com.example.seollyongdan_frontend.ui.theme.h4Bold
import com.example.seollyongdan_frontend.ui.theme.h4Semi
import com.example.seollyongdan_frontend.ui.theme.h5Semi
import com.example.seollyongdan_frontend.ui.theme.h7Bold
import com.google.accompanist.systemuicontroller.rememberSystemUiController

@Composable
fun SearchResultRoute(
    navigator: SearchNavigator,
    safety : String,
    traffic : String,
    real_estate : String,
    amenities : String
){
    val systemUiController = rememberSystemUiController()
    val searchViewModel: SearchViewModel = hiltViewModel()
    val mainViewModel: MainViewModel = hiltViewModel()

    SideEffect {
        systemUiController.setStatusBarColor(
            color = Color.White
        )
    }

    SearchResultScreen(
        onBackClick = { navigator.navigateBack() },
        searchViewModel = searchViewModel,
        mainViewModel = mainViewModel,
        safety = safety,
        traffic = traffic,
        real_estate = real_estate,
        amenities = amenities
    )
}

@Composable
fun SearchResultScreen(
    onBackClick: () -> Unit,
    searchViewModel: SearchViewModel,
    mainViewModel: MainViewModel,
    safety : String,
    traffic : String,
    real_estate : String,
    amenities : String
) {
    val safetyValue by searchViewModel.safety.collectAsState()
    val trafficValue by searchViewModel.traffic.collectAsState()
    val realEstateValue by searchViewModel.realEstate.collectAsState()
    val amenitiesValue by searchViewModel.amenities.collectAsState()

    val town by searchViewModel.town.collectAsState()
    val description by searchViewModel.townDescription.collectAsState()
    val userDto by mainViewModel.userDto.collectAsStateWithLifecycle()
    val userName = userDto?.nickname ?: "이눈송"

    LaunchedEffect(Unit){
        searchViewModel.postSearchFilter(safety, traffic, real_estate, amenities)
    }


    Column(
        modifier = Modifier
            .background(color = White)
            .fillMaxWidth()
            .padding(16.dp)
    ) {
        IconButton(
            onClick = onBackClick,
            modifier = Modifier
                .width(11.dp)
                .height(24.dp)
        ) {
            Icon(
                imageVector = ImageVector.vectorResource(id = R.drawable.ic_back),
                contentDescription = "이전으로 돌아가기",
            )
        }
        Spacer(modifier = Modifier.height(27.dp))

        Row {
            Text(
                text = "${userName}",
                style = h4Bold
            )
            Text(
                "님과 딱 맞는 지역구",
                style = h4Bold
            )
        }
        Spacer(modifier = Modifier.height(12.dp))
        Text(
            text = "${description}",
            style = h5Semi,
            color = Primary900
        )
        Spacer(modifier = Modifier.height(30.dp))
        Row() {
            Box(
                modifier = Modifier
                    .background(color = Gray50, shape = RoundedCornerShape(20.dp))
                    .width(172.dp)
                    .padding(16.dp)
            ) {
                Row(
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.ic_home_lock),
                        contentDescription = "안전 및 치안",
                        modifier = Modifier
                            .size(50.dp)
                            .padding(end = 10.dp)
                    )
                    Column {
                        Text(
                            "안전 및 치안",
                            style = h7Bold
                        )
                        Text(
                            "${safetyValue}",
                            style = h4Semi,
                            color = Primary900
                        )
                    }
                }
            }
            Spacer(modifier = Modifier.width(10.dp))
            Box(
                modifier = Modifier
                    .background(color = Gray50, shape = RoundedCornerShape(20.dp))
                    .width(172.dp)
                    .padding(16.dp)
            ) {
                Row(
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.ic_home_traffic),
                        contentDescription = "교통",
                        modifier = Modifier
                            .size(50.dp)
                            .padding(end = 10.dp)
                    )
                    Column {
                        Text(
                            "교통",
                            style = h7Bold
                        )
                        Text(
                            "${trafficValue ?: "알 수 없음"}",
                            style = h4Semi,
                            color = Primary900
                        )
                    }
                }
            }
        }
        Spacer(modifier = Modifier.height(10.dp))
        Row() {
            Box(
                modifier = Modifier
                    .background(color = Gray50, shape = RoundedCornerShape(20.dp))
                    .width(172.dp)
                    .padding(16.dp)
            ) {
                Row(
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.ic_search_coin),
                        contentDescription = "부동산 및 환경",
                        modifier = Modifier
                            .size(50.dp)
                            .padding(end = 10.dp)
                    )
                    Column {
                        Text(
                            "부동산/환경",
                            style = h7Bold
                        )
                        Text(
                            "${realEstateValue}",
                            style = h4Semi,
                            color = Primary900
                        )
                    }
                }
            }
            Spacer(modifier = Modifier.width(10.dp))
            Box(
                modifier = Modifier
                    .background(color = Gray50, shape = RoundedCornerShape(20.dp))
                    .width(172.dp)
                    .padding(16.dp)
            ) {
                Row(
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.ic_home_life),
                        contentDescription = "생활 인프라",
                        modifier = Modifier
                            .size(50.dp)
                            .padding(end = 10.dp)
                    )
                    Column {
                        Text(
                            "생활 인프라",
                            style = h7Bold
                        )
                        Text(
                            "${amenitiesValue}",
                            style = h4Semi,
                            color = Primary900
                        )
                    }
                }
            }
        }
        Spacer(modifier = Modifier.height(50.dp))
        Text(
            "해당 그룹에 속하는 지역구",
            style = h4Semi
        )
        Spacer(modifier = Modifier.height(10.dp))
        //Text(
        //    "클릭하면 메인페이지의 동네가 해당 동네로 설정되며\n 상세 정보를 확인해볼 수 있습니다.",
        //    style = b1Semi,
        //    color = Primary900
        //)
        Spacer(modifier = Modifier.height(38.dp))
        town?.forEach { district ->
            DistrictButton(color = Primary900, district = district, onClick = {
            })
            Spacer(modifier = Modifier.height(10.dp))
        }
    }
}