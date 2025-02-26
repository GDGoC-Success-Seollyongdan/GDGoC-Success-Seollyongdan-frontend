package com.example.seollyongdan_frontend.presentation.home.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.seollyongdan_frontend.R
import com.example.seollyongdan_frontend.ui.component.HomeButton
import com.example.seollyongdan_frontend.ui.theme.Gray500
import com.example.seollyongdan_frontend.ui.theme.Gray900
import com.example.seollyongdan_frontend.ui.theme.Success500
import com.example.seollyongdan_frontend.ui.theme.Success800
import com.example.seollyongdan_frontend.ui.theme.Success900
import com.example.seollyongdan_frontend.ui.theme.White
import com.example.seollyongdan_frontend.ui.theme.h5Bold
import com.example.seollyongdan_frontend.ui.theme.h5Semi
import com.example.seollyongdan_frontend.ui.theme.h7Regular

@Composable
fun BottomSheetMainScreen(
    homeViewModel: HomeViewModel,
    onSearchClick: () -> Unit,
    districtName : String,
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
                districtName,
                color = Success800,
                style = h5Bold
            )
            Text(
                " 상세 정보",
                color = Gray900,
                style = h5Bold
            )
        }
        HomeButton(
            imageId = R.drawable.ic_home_lock,
            value1 = "범죄 발생 및 빈도를 알고 싶다면",
            value2 = "안전 및 치안",
            onClick = { homeViewModel.setBottomSheetScreen(BottomSheetScreen.SAFETY) }
        )
        HomeButton(
            imageId = R.drawable.ic_home_realestate,
            value1 = "전월세가 정보를 알고 싶다면",
            value2 = "부동산",
            onClick = { homeViewModel.setBottomSheetScreen(BottomSheetScreen.REAL_ESTATE) }
        )
        HomeButton(
            imageId = R.drawable.ic_home_traffic,
            value1 = "교통 혼잡도를 알고 싶다면",
            value2 = "교통",
            onClick = { homeViewModel.setBottomSheetScreen(BottomSheetScreen.TRAFFIC) }
        )
        HomeButton(
            imageId = R.drawable.ic_home_life,
            value1 = "문화시설 및 상권 현황을 알고 싶다면",
            value2 = "생활/편의시설",
            onClick = { homeViewModel.setBottomSheetScreen(BottomSheetScreen.LIFE) }
        )
        HomeButton(
            imageId = R.drawable.ic_home_review,
            value1 = "동네 사람들의 평가를 알고 싶다면",
            value2 = "리뷰 및 별점",
            onClick = { homeViewModel.setBottomSheetScreen(BottomSheetScreen.REVIEW) }
        )
        Button(
            modifier = Modifier
                .fillMaxWidth()
                .height(87.dp),
            shape = RoundedCornerShape(15.dp),
            onClick = onSearchClick,
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