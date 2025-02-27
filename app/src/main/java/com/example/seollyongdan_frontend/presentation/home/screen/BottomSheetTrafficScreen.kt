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
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
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
import com.example.seollyongdan_frontend.ui.component.MainToVisualizationButton
import com.example.seollyongdan_frontend.ui.component.PieGraph
import com.example.seollyongdan_frontend.ui.component.TrafficTable
import com.example.seollyongdan_frontend.ui.theme.Success500
import com.example.seollyongdan_frontend.ui.theme.Success800
import com.example.seollyongdan_frontend.ui.theme.Success900
import com.example.seollyongdan_frontend.ui.theme.White
import com.example.seollyongdan_frontend.ui.theme.h5Bold
import com.example.seollyongdan_frontend.ui.theme.h7Semi

@Composable
fun BottomSheetTrafficScreen(
    homeViewModel: HomeViewModel,
    trafficViewModel: TrafficViewModel,
    districtName: String,
    onTrafficVisualizationClick : () -> Unit
) {
    val townId = townNameToId(districtName)

    LaunchedEffect(districtName){
        trafficViewModel.getHomeTraffic(townId)
    }

    val onBackClick = { homeViewModel.setBottomSheetScreen(BottomSheetScreen.HOME) }

    val trafficTrue = trafficViewModel.isHigh //혼잡도 상위 5위 여부

    val trafficDistricts = listOf("강남구", "중구", "성북구", "송파구", "동작구", "기타")
    val trafficValues = listOf(30f, 20f, 15f, 10f, 15f, 10f)

    val trafficTableData = listOf(trafficViewModel.busRatio.toString(), trafficViewModel.subwayRatio.toString(), trafficViewModel.taxiRatio.toString()) //해당 구 대중교통 이용 비율 - 백엔드에서 받아오는 형태로 수정 필요
    val trafficMajor = trafficViewModel.mostUsedTransport



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
                append(" 교통 현황")
            }, style = h5Bold)
        }

        MainToVisualizationButton(
            onClick = onTrafficVisualizationClick,
            text = "서울시 구별 교통 혼잡도"
        )

        Box(
            modifier = Modifier
                .height(280.dp)
                .fillMaxWidth()
                .clip(RoundedCornerShape(30.dp))
                .background(Success500)
                .padding(top = 11.dp, start = 21.dp)
        ) {
            Column {

                Text(
                    "대중교통 이용 비율", style = h7Semi,
                    //modifier = Modifier.padding(start = 11.dp)
                )

                Spacer(modifier = Modifier.height(25.dp))

                TrafficTable(trafficTableData)

                Spacer(modifier = Modifier.height(25.dp))

                Text(text = buildAnnotatedString {
                    append("$districtName 주민들은 ")
                    withStyle(style = SpanStyle(color = Success800)) {
                        append("{$trafficMajor}를 가장 많이 이용해요")
                    }
                }, style = h7Semi)


            }

        }


        Box(
            modifier = Modifier
                .wrapContentHeight()
                .clip(RoundedCornerShape(30.dp))
                .background(Success500)
                .padding(top = 11.dp)
        ) {

            Column {

                Column (modifier = Modifier.padding(start = 21.dp)) {
                    Text("대중교통 혼잡도", style = h7Semi)

                    Spacer(modifier = Modifier.height(20.dp))
                }

                    Box(modifier = Modifier.height(280.dp)) {
                        PieGraph(data = trafficValues, labels = trafficDistricts)
                    }


                    Text(text = buildAnnotatedString {
                        append("서울시 기준 혼잡도 ")
                        withStyle(style = SpanStyle(color = Success900)) {
                            append("상위 5위")
                        }
                        if (trafficTrue) {
                            append("에 포함돼요")
                        } else {
                            append("에 포함되지 않아요")
                        }
                    }, style = h7Semi, modifier = Modifier.padding(start = 21.dp))

                    Spacer(modifier = Modifier.height(15.dp))



            }

        }


    }
}

@Preview
@Composable
fun TrafficScreenPreview() {
    BottomSheetTrafficScreen(
        homeViewModel = viewModel(),
        trafficViewModel = viewModel(),
        districtName = "성북구",
        onTrafficVisualizationClick = {}
    )
}