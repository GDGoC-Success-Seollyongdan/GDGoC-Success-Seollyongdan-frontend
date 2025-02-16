package com.example.seollyongdan_frontend.presentation.home.screen

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
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Star
import androidx.compose.material.icons.outlined.Clear
import androidx.compose.material.icons.outlined.Star
import androidx.compose.material.icons.twotone.Star
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
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
import com.example.seollyongdan_frontend.ui.component.HomeButton
import com.example.seollyongdan_frontend.ui.component.UserReview
import com.example.seollyongdan_frontend.ui.theme.Success400
import com.example.seollyongdan_frontend.ui.theme.Success800
import com.example.seollyongdan_frontend.ui.theme.Success900
import com.example.seollyongdan_frontend.ui.theme.White
import com.example.seollyongdan_frontend.ui.theme.h4Bold
import com.example.seollyongdan_frontend.ui.theme.h5Bold
import com.example.seollyongdan_frontend.ui.theme.h6Semi

@Composable
fun BottomSheetReviewScreen(
    homeViewModel: HomeViewModel,
    districtName : String
) {
    val onBackClick = { homeViewModel.setBottomSheetScreen(BottomSheetScreen.HOME) }
    val reviewList = listOf(
        Pair(4.5f, "치안이 좋아요"),
        Pair(3.8f, "대중교통이 편리해요"),
        Pair(4.2f, "주변에 맛집이 많아요"),
        Pair(4.2f, "주변에 맛집이 많아요")
    )

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
                        append(" 리뷰 및 평가")
                    }
                },
                style = h5Bold
            )
        }
        Spacer(modifier = Modifier.height(20.dp))
        Box(
            modifier = Modifier
                .wrapContentHeight()
                .width(255.dp)
                .background(
                    color = Success400,
                    shape = RoundedCornerShape(20)
                )
                .padding(10.dp)
                .align(Alignment.CenterHorizontally),
            contentAlignment = Alignment.Center
        ) {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                //FIXME 하드코딩 수정
                Text(
                    "4.4",
                    style = h4Bold
                )
                StaticRatingBar(4.4f)
            }
        }
        Spacer(modifier = Modifier.height(55.dp))
        Text(
            "실거주하시는 분들의 솔직한 의견이에요",
            style = h6Semi
        )
        Spacer(modifier = Modifier.height(16.dp))
        LazyColumn(
            modifier = Modifier
                .fillMaxWidth()
        ) {
            reviewList.forEach { (rating, message) ->
                item {
                    UserReview(starRate = rating, message = message)
                }
                item { Spacer(modifier = Modifier.height(12.dp)) }
            }
        }
    }
}

@Composable
fun StaticRatingBar(rating: Float) {
    Row {
        for ( i in 1.. 5) {
            Icon(
                imageVector = if (i < rating) Icons.Filled.Star else Icons.TwoTone.Star,
                contentDescription = "별점 매기기",
                tint = Success900,
                modifier = Modifier.size(25.dp)
            )
        }
    }
}

@Preview
@Composable
fun BottomSheetReviewScreenPreview() {
    val dummyViewModel = HomeViewModel()
    BottomSheetReviewScreen(
        homeViewModel = dummyViewModel,
        districtName = "성북구"
    )
}