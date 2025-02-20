package com.example.seollyongdan_frontend.presentation.community.screen

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.seollyongdan_frontend.R
import com.example.seollyongdan_frontend.presentation.community.navigation.CommunityNavigator
import com.example.seollyongdan_frontend.ui.component.ContentTextField
import com.example.seollyongdan_frontend.ui.component.PostButton
import com.example.seollyongdan_frontend.ui.theme.Info400
import com.example.seollyongdan_frontend.ui.theme.White
import com.example.seollyongdan_frontend.ui.theme.h2Semi
import com.example.seollyongdan_frontend.ui.theme.h3Semi

@Composable
fun CommunityReviewRoute(
    navigator: CommunityNavigator,
    district: String
) {
    CommunityReviewScreen(
        onBackClick = { navigator.navigateBack() },
        onReviewClick = { navigator.navigateToCommunity() },
        district = district
    )

}


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CommunityReviewScreen(
    onBackClick: () -> Unit,
    onReviewClick: () -> Unit,
    district: String
) {
    var content by remember { mutableStateOf("") }
    var rating by remember { mutableIntStateOf(0) }


    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text("리뷰 남기기", style = h3Semi)
                },
                navigationIcon = {
                    IconButton(
                        onClick = onBackClick
                    ) {
                        Icon(
                            painter = painterResource(id = R.drawable.ic_back),
                            contentDescription = "뒤로 가기"
                        )
                    }
                },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = White
                )
            )
        },
    ) { paddingValues ->

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
                .padding(horizontal = 30.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            Spacer(modifier = Modifier.height(50.dp))

            Text(district, style = h2Semi, color = Info400)

            Spacer(modifier = Modifier.height(20.dp))

            Text("동네에서의\n경험은 어땠나요?", style = h3Semi, textAlign = TextAlign.Center)

            Spacer(modifier = Modifier.height(30.dp))

            StarRating(
                rating = rating,
                onRatingChange = { rating = it }
            )

            Spacer(modifier = Modifier.height(50.dp))

            ContentTextField(
                value = content,
                onValueChange = { content = it },
                placeholderText = "경험이나 메모를 남겨보세요. (선택)",
                height = 60
            )

            Spacer(modifier = Modifier.height(50.dp))


            PostButton(
                value = "등록",
                onClick = onReviewClick
            )


        }

    }


}

@Composable
fun StarRating(
    rating: Int,
    onRatingChange: (Int) -> Unit
) {
    val starCount = 5

    LazyRow() {
        items(starCount) { index ->
            IconButton(
                onClick = {
                    onRatingChange(index + 1)
                }
            ) {
                Icon(
                    painter = painterResource(
                        id = (if (index < rating) {
                            R.drawable.ic_star_selected
                        } else {
                            R.drawable.ic_star_unselected
                        })
                    ),
                    contentDescription = "별",
                    tint = Color.Unspecified
                )
            }

        }
    }
}

@Preview
@Composable
fun ReviewScreenPreview(){
    CommunityReviewScreen(
        onReviewClick = {},
        onBackClick = {},
        district = "용산구 청파로2가"
    )
}