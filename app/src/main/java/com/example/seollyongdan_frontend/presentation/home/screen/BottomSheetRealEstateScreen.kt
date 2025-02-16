package com.example.seollyongdan_frontend.presentation.home.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.seollyongdan_frontend.R
import com.example.seollyongdan_frontend.ui.component.HomeButton
import com.example.seollyongdan_frontend.ui.component.LineGraph
import com.example.seollyongdan_frontend.ui.theme.Success500
import com.example.seollyongdan_frontend.ui.theme.Success800
import com.example.seollyongdan_frontend.ui.theme.Success900
import com.example.seollyongdan_frontend.ui.theme.White
import com.example.seollyongdan_frontend.ui.theme.h5Bold
import com.example.seollyongdan_frontend.ui.theme.h7Semi

@Composable
fun BottomSheetRealEstateScreen(
    homeViewModel: HomeViewModel,
    districtName: String
) {
    val onBackClick = { homeViewModel.setBottomSheetScreen(BottomSheetScreen.HOME) }
    val priceMonth = listOf("1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12")
    val priceValues = listOf(
        930f,
        935f,
        940f,
        950f,
        955f,
        960f,
        965f,
        970f,
        960f,
        950f,
        945f,
        940f
    )
    Column(
        modifier = Modifier
            .background(color = White)
            .fillMaxWidth()
            .padding(16.dp)
    ) {
        Row {
            IconButton(
                onClick = onBackClick,
                modifier = Modifier
                    .width(11.dp)
                    .height(24.dp)
            ) {
                Icon(
                    imageVector = ImageVector.vectorResource(id = R.drawable.ic_back_brown),
                    contentDescription = "이전으로 돌아가기"
                )
            }

            Spacer(modifier = Modifier.width(17.dp))
            Text (
                buildAnnotatedString {
                    withStyle(style = SpanStyle(Success800)) {
                        append(districtName)
                    }
                    withStyle(style = SpanStyle(Color.Black)) {
                        append(" 생활/편의시설")
                    }
                },
                style = h5Bold
            )
        }
        Spacer(modifier = Modifier.padding(8.dp))
        Box(
            modifier = Modifier
                .background(
                    color = Success500,
                    shape = RoundedCornerShape(30.dp)
                )
                .padding(16.dp)
                .height(290.dp)
        ) {
            Column(
                modifier = Modifier
                    .padding(bottom = 8.dp)
            ) {
                Text(
                    "1년간 시세 변화 추이(2023)",
                    style = h7Semi,
                    color = Color.Black,
                    modifier = Modifier
                        .padding(bottom = 8.dp)
                )
                LineGraph(priceMonth, priceValues)
            }
        }
        Spacer(modifier = Modifier.padding(16.dp))
        Box(
            modifier = Modifier
                .background(
                    color = Success500,
                    shape = RoundedCornerShape(30.dp)
                )
                .size(width = 355.dp, height = 240.dp)
                .padding(16.dp),
        ) {
            Column(
                modifier = Modifier
                    .padding(start = 5.dp),
                verticalArrangement = Arrangement.spacedBy(16.dp)
            ) {
                Row() {
                    Text(
                        "아파트 평당 평균 ",
                        style = h7Semi,
                        color = Color.Black
                    )
                    Text(
                        "매매/전세/월세가",
                        style = h7Semi,
                        color = Success900
                    )
                }
                //FIXME 백에서 정보 받아오기
                Row(
                    modifier = Modifier
                        .padding(top = 8.dp),
                    horizontalArrangement = Arrangement.spacedBy(50.dp)
                ) {
                    Text(
                        "매매 ",
                        style = h7Semi
                    )
                    Text(
                        "4,000,000,000",
                        style = h7Semi
                    )
                }
                Row(
                    horizontalArrangement = Arrangement.spacedBy(50.dp)
                ) {
                    Text(
                        "전세 ",
                        style = h7Semi
                    )
                    Text(
                        "3,000,000,000",
                        style = h7Semi
                    )
                }
                Row(
                    modifier = Modifier
                        .padding(bottom = 8.dp),
                    horizontalArrangement = Arrangement.spacedBy(50.dp)
                ) {
                    Text(
                        "월세 ",
                        style = h7Semi
                    )
                    Text(
                        "500,000 / 100,000",
                        style = h7Semi
                    )
                }
                Text(
                    buildAnnotatedString {
                        withStyle(style = SpanStyle(color = Color.Black)) {
                            append("서울시 기준 ")
                        }
                        withStyle(style = SpanStyle(color = Success800)) {
                            append("상위 5위")
                        }
                        withStyle(style = SpanStyle(color = Color.Black)) {
                            append("에 포함돼요")
                        }
                    },
                    style = h7Semi,
                )
            }
        }
    }
}

@Preview
@Composable
fun RealEstateScreenPreview() {
    val dummyViewModel = HomeViewModel()
    BottomSheetRealEstateScreen(
        homeViewModel = dummyViewModel,
        districtName = "성북구"
    )
}