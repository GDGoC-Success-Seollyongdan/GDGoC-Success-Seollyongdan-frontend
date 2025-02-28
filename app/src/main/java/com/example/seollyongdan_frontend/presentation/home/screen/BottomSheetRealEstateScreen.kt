package com.example.seollyongdan_frontend.presentation.home.screen

import android.util.Log
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
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.seollyongdan_frontend.R
import com.example.seollyongdan_frontend.domain.repository.HomeRepository
import com.example.seollyongdan_frontend.ui.component.LineGraph
import com.example.seollyongdan_frontend.ui.theme.Success500
import com.example.seollyongdan_frontend.ui.theme.Success800
import com.example.seollyongdan_frontend.ui.theme.Success900
import com.example.seollyongdan_frontend.ui.theme.White
import com.example.seollyongdan_frontend.ui.theme.b1Semi
import com.example.seollyongdan_frontend.ui.theme.h5Bold
import com.example.seollyongdan_frontend.ui.theme.h7Semi

@Composable
fun BottomSheetRealEstateScreen(
    homeViewModel: HomeViewModel,
    realEstateViewModel: RealEstateViewModel,
    districtName: String
) {
    val onBackClick = { homeViewModel.setBottomSheetScreen(BottomSheetScreen.HOME) }
    val priceMonth = listOf("1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12")


    val monthlyRent by remember { realEstateViewModel.monthlyRent }
    val yearlyRent by remember {realEstateViewModel.yearlyRent  }
    val priceValues by realEstateViewModel.saleData.collectAsState()
    val priceDifference1y by remember {  realEstateViewModel.priceDifference1y}

    val defaultValues = listOf(0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f)
    val lastSaleData = priceValues?.lastOrNull() ?: 0.0f

    Log.d("BottomSheetRealEstate", "monthlyRent: $monthlyRent")
    Log.d("BottomSheetRealEstate", "yearlyRent: $yearlyRent")
    Log.d("BottomSheetRealEstate", "priceValues: $priceValues")
    Log.d("BottomSheetRealEstate", "priceDifference1y: $priceDifference1y")

    val townId = townNameToId(districtName)
    Log.d("BottomSheetRealEstate", "districtName: $districtName, townId: $townId")
    LaunchedEffect(districtName) {
        realEstateViewModel.getHomeRealEstate(townId)
        Log.d("RealEstateViewModel", "townId: $townId")
    }
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
                        append(" 부동산")
                    }
                },
                style = h5Bold
            )
        }
        Spacer(modifier = Modifier.padding(8.dp))
        Box(
            modifier = Modifier
                .wrapContentHeight()
                .fillMaxWidth()
                .background(
                    color = Success500,
                    shape = RoundedCornerShape(30.dp)
                )
                .padding(16.dp)

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
                LineGraph(priceMonth, priceValues ?: defaultValues)
                Spacer(modifier = Modifier.height(21.dp))
                Text(
                    text = districtName + " 부동산은",
                    style = b1Semi,
                    color = Success900
                )
                Text(
                    buildAnnotatedString {
                        withStyle(style = SpanStyle(color = Color.Black)) {
                            append("1년 전 오늘보다 평균 ")
                        }
                        withStyle(style = SpanStyle(color = Success900)) {
                            append("${priceDifference1y ?: "알 수 없음"}원")
                        }
                        withStyle(style = SpanStyle(color = Color.Black)) {
                            append("가량 올랐어요")
                        }
                    },
                    style = b1Semi,
                )
            }
        }
        Spacer(modifier = Modifier.padding(16.dp))
        Box(
            modifier = Modifier
                .wrapContentHeight()
                .fillMaxWidth()
                .background(
                    color = Success500,
                    shape = RoundedCornerShape(30.dp)
                )
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
                        text = "${lastSaleData ?: "알 수 없음"}",
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
                        text = "${yearlyRent ?: "알 수 없음"}",
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
                        text = "${monthlyRent ?: "알 수 없음"}",
                        style = h7Semi
                    )
                }
//                Text(
//                    buildAnnotatedString {
//                        withStyle(style = SpanStyle(color = Color.Black)) {
//                            append("서울시 기준 ")
//                        }
//                        withStyle(style = SpanStyle(color = Success800)) {
//                            append("상위 5위")
//                        }
//                        withStyle(style = SpanStyle(color = Color.Black)) {
//                            append("에 포함돼요")
//                        }
//                    },
//                    style = h7Semi,
//                )
            }
        }
    }
}

@Preview
@Composable
fun RealEstateScreenPreview() {
    BottomSheetRealEstateScreen(
        homeViewModel = viewModel(),
        realEstateViewModel = viewModel(),
        districtName = "성북구"
    )
}