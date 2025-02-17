package com.example.seollyongdan_frontend.presentation.home.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
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
import com.example.seollyongdan_frontend.R
import com.example.seollyongdan_frontend.ui.component.BarGraph
import com.example.seollyongdan_frontend.ui.component.HomeButton
import com.example.seollyongdan_frontend.ui.component.LifeTable
import com.example.seollyongdan_frontend.ui.component.LineGraph
import com.example.seollyongdan_frontend.ui.theme.Success500
import com.example.seollyongdan_frontend.ui.theme.Success800
import com.example.seollyongdan_frontend.ui.theme.Success900
import com.example.seollyongdan_frontend.ui.theme.White
import com.example.seollyongdan_frontend.ui.theme.h5Bold
import com.example.seollyongdan_frontend.ui.theme.h7Semi

@Composable
fun BottomSheetLifeScreen(
    homeViewModel: HomeViewModel,
    districtName : String
) {
    val onBackClick = { homeViewModel.setBottomSheetScreen(BottomSheetScreen.HOME) }
    val serviceCategory = listOf("강남구", "강동구", "강북구", "강서구", "관악구")
    val serviceValues = listOf(30f, 22.5f, 20f, 17.5f, 12.5f)
    val LifeTrue = false
    val LifeTableData = listOf("50", "30", "15", "4")

    Column(
        modifier = Modifier
            .background(White)
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
                        append(" 부동산 현황")
                    }
                },
                style = h5Bold
            )
        }
        Spacer(modifier = Modifier.padding(8.dp))
        Box(
            modifier = Modifier
                .wrapContentHeight()
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
                    "지역구별 문화체육시설 비율",
                    style = h7Semi,
                    color = Color.Black,
                    modifier = Modifier
                        .padding(bottom = 8.dp)
                )
                BarGraph(serviceValues, serviceCategory)
                Spacer(modifier = Modifier.height(15.dp))
                Text(text = buildAnnotatedString {
                    append("서울시 기준 ")
                    withStyle(style = SpanStyle(color = Success900)) {
                        append("상위 5위")
                    }
                    if (LifeTrue) {
                        append("에 포함돼요")
                    } else {
                        append("에 포함되지 않아요")
                    }
                }, style = h7Semi)
            }
        }
        Spacer(modifier = Modifier.padding(16.dp))
        Box(
            modifier = Modifier.background(
                color = Success500,
                shape = RoundedCornerShape(30.dp)
            )
                .wrapContentHeight()
                .padding(16.dp)
        ) {
            Column {
                Text("주요 상권 TOP4", style = h7Semi)
                Spacer(modifier = Modifier.height(20.dp))
                LifeTable(LifeTableData)
            }
        }
    }
}

@Preview
@Composable
fun BottomSheetLifeScreenPreview() {
    val dummyViewModel = HomeViewModel()
    BottomSheetLifeScreen(
        homeViewModel = dummyViewModel,
        districtName = "성북구"
    )
}