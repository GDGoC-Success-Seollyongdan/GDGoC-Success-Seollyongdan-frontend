package com.example.seollyongdan_frontend.presentation.home.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.seollyongdan_frontend.R
import com.example.seollyongdan_frontend.ui.component.LineGraph
import com.example.seollyongdan_frontend.ui.component.MainToVisualizationButton
import com.example.seollyongdan_frontend.ui.component.PieGraph
import com.example.seollyongdan_frontend.ui.component.SafetyTable
import com.example.seollyongdan_frontend.ui.theme.Success500
import com.example.seollyongdan_frontend.ui.theme.Success800
import com.example.seollyongdan_frontend.ui.theme.Success900
import com.example.seollyongdan_frontend.ui.theme.White
import com.example.seollyongdan_frontend.ui.theme.h5Bold
import com.example.seollyongdan_frontend.ui.theme.h7Semi

@Composable
fun BottomSheetSafetyScreen(
    homeViewModel: HomeViewModel,
    districtName: String,
    onSafetyVisualizationClick : () -> Unit
) {
    val onBackClick = { homeViewModel.setBottomSheetScreen(BottomSheetScreen.HOME) }

    val crimeYears = listOf("2015", "2016", "2017", "2018", "2019", "2020", "2021", "2022", "2023")
    val crimeValues = listOf(
        3.2f,
        3.0f,
        3.1f,
        2.9f,
        2.8f,
        2.7f,
        2.6f,
        2.5f,
        2.6f
    ) //10년간 범죄율 - 백엔드에서 받아오는 형태로 수정 필요
    val SafetyTrue = true //안심시설 상위 5위 여부 - 백엔드에서 받아오는 형태로 수정 필요

    val safetyDistricts = listOf("강남구", "중구", "성북구", "송파구", "동작구", "기타")
    val safetyValues = listOf(30f, 20f, 15f, 10f, 15f, 10f)

    val safetyTableData = listOf("123", "100", "234") //해당 구 안심시설 개수 - 백엔드에서 받아오는 형태로 수정 필요




    Column(
        modifier = Modifier
            .wrapContentHeight()
            .fillMaxWidth()
            .background(color = White)
            .verticalScroll(rememberScrollState()) // 스크롤 가능하게 설정
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(17.dp)
    ) {

        Row {
            IconButton(onClick = onBackClick, modifier = Modifier
                .width(11.dp)
                .height(24.dp)) {
                Icon(
                    imageVector = ImageVector.vectorResource(id = R.drawable.ic_back_brown),
                    contentDescription = "이전으로 돌아가기"
                )
            }

            Spacer(modifier = Modifier.width(17.dp))

            Text(text = buildAnnotatedString {
                withStyle(style = SpanStyle(color = Success800)) {
                    append(districtName)
                }
                append(" 안전 및 치안")
            }, style = h5Bold)
        }

        MainToVisualizationButton(
            onClick = onSafetyVisualizationClick,
            text = "서울시 구별 범죄 발생 빈도"
        )

        Box(
            modifier = Modifier
                .height(266.dp)
                .clip(RoundedCornerShape(30.dp))
                .background(Success500)
                .padding(top = 11.dp, start = 5.dp)
        ) {
            Column {

                Text(
                    "$districtName 에서의 10년간 범죄율 변화", style = h7Semi,
                    modifier = Modifier.padding(start = 11.dp)
                )

                Spacer(modifier = Modifier.height(5.dp))

                LineGraph(crimeYears, crimeValues)
            }

        }

        //Spacer(modifier = Modifier.height(10.dp))

        Box(
            modifier = Modifier
                .wrapContentHeight()
                .clip(RoundedCornerShape(30.dp))
                .background(Success500)
                .padding(top = 11.dp)
        ) {

            Column {

                Column (modifier = Modifier.padding(start = 16.dp)){
                    Text("$districtName 주민 안심 시설 현황", style = h7Semi)

                    Spacer(modifier = Modifier.height(20.dp))

                    SafetyTable(safetyTableData)

                    Spacer(modifier = Modifier.height(15.dp))


                    Text(text = buildAnnotatedString {
                        append("서울시 기준 ")
                        withStyle(style = SpanStyle(color = Success900)) {
                            append("상위 5위")
                        }
                        if (SafetyTrue) {
                            append("에 포함돼요")
                        } else {
                            append("에 포함되지 않아요")
                        }
                    }, style = h7Semi)

                    Spacer(modifier = Modifier.height(10.dp))

                }

                Box(modifier = Modifier.height(280.dp)) {
                    PieGraph(data = safetyValues, labels = safetyDistricts)
                }

            }

        }


    }
}

@Preview
@Composable
fun SafetyScreenPreview() {
    BottomSheetSafetyScreen(
        homeViewModel = viewModel(),
        districtName = "성북구",
        onSafetyVisualizationClick = {}
    )
}