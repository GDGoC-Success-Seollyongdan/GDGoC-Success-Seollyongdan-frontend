package com.example.seollyongdan_frontend.presentation.community.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.seollyongdan_frontend.R
import com.example.seollyongdan_frontend.presentation.community.navigation.CommunityNavigator
import com.example.seollyongdan_frontend.ui.theme.Gray100
import com.example.seollyongdan_frontend.ui.theme.Gray300
import com.example.seollyongdan_frontend.ui.theme.Gray50
import com.example.seollyongdan_frontend.ui.theme.White
import com.example.seollyongdan_frontend.ui.theme.b3Bold

@Composable
fun CommunityDetailRoute(
    navigator: CommunityNavigator,
    id: Int,
    district: String
) {
    val communityDetailViewModel: CommunityDetailViewModel = hiltViewModel()


    CommunityDetailScreen(
        onBackClick = { navigator.navigateBack() },
        communityDetailViewModel = communityDetailViewModel,
        id = id,
        communityDistrict = district
    )

}


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CommunityDetailScreen(
    onBackClick: () -> Unit,
    communityDetailViewModel: CommunityDetailViewModel,
    id: Int,
    communityDistrict: String
) {
    var content by remember { mutableStateOf("") }

    val communityDetailState by communityDetailViewModel.communityDetailList.collectAsState()

    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text("")
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

        Column(modifier = Modifier
            .fillMaxSize()
            .padding(paddingValues)) {
            LazyColumn(modifier = Modifier.weight(1f)) {
                item {
                    CommunityPostDetailItem(
                        communityDetailState.post,
                        communityDistrict
                    )

                    Spacer(modifier = Modifier.height(10.dp))

                    Box(
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(1.dp)
                            .background(Gray100)
                    )

                    Spacer(modifier = Modifier.height(15.dp))

                    Text(
                        modifier = Modifier.padding(start = 24.dp),
                        text = "댓글 ${communityDetailState.post.comment}",
                        style = b3Bold
                    )
                }

                items(communityDetailState.comments) { item ->
                    CommunityDetailCommentItem(data = item, communityDistrict = communityDistrict)
                }
            }

            // 댓글 입력창 + 등록 버튼
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                TextField(
                    value = content,
                    onValueChange = { content = it },
                    modifier = Modifier
                        .weight(1f)
                        .height(56.dp),
                    shape = RoundedCornerShape(10.dp),
                    placeholder = { Text("댓글을 입력하세요") },
                    colors = TextFieldDefaults.colors(
                        focusedContainerColor = Gray50,
                        unfocusedContainerColor = Gray50,
                        focusedIndicatorColor = Color.Transparent,
                        unfocusedIndicatorColor = Color.Transparent,
                        focusedTextColor = Gray300,
                        unfocusedTextColor = Gray300
                    ),
                    trailingIcon = {
                        IconButton(
                            modifier = Modifier.size(30.dp),
                            onClick = {
                                if (content.isNotBlank()) {
                                    communityDetailViewModel.addComment(content)
                                    content = ""
                                }
                            }
                        ) {
                            Icon(
                                painter = painterResource(id = R.drawable.ic_send),
                                contentDescription = "전송"
                            )
                        }
                    }
                )


            }
        }
    }
}

@Preview
@Composable
fun DetailScreenPreview() {
    CommunityDetailScreen(
        onBackClick = {},
        communityDetailViewModel = viewModel(),
        id = 1,
        communityDistrict = "용산구 청파로2가"
    )
}