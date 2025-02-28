package com.example.seollyongdan_frontend.presentation.community.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.imeNestedScroll
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
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.sellyongdan_frontend.util.toast
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

    val communityPostViewModel : CommunityPostViewModel = hiltViewModel()


    CommunityDetailScreen(
        onBackClick = { navigator.navigateBack() },
        communityPostViewModel = communityPostViewModel,
        postId = id,
        communityDistrict = district
    )

}


@OptIn(ExperimentalMaterial3Api::class, ExperimentalLayoutApi::class)
@Composable
fun CommunityDetailScreen(
    onBackClick: () -> Unit,
    communityPostViewModel: CommunityPostViewModel,
    postId: Int,
    communityDistrict: String
) {
    var content by remember { mutableStateOf("") }
    val isSuccess by communityPostViewModel.isCommentPostSuccess
    val context = LocalContext.current
    val focusManager = LocalFocusManager.current


    LaunchedEffect(postId){
        communityPostViewModel.getCommunityPostDetail(postId)
        communityPostViewModel.getCommunityPostComments(postId)
    }


    LaunchedEffect(isSuccess) {
        if (isSuccess == true) {
            onBackClick()
        } else if (isSuccess == false) {
            context.toast("게시글 등록에 실패했습니다.")
        }
    }

    // LiveData를 State로 변환
    val postComments by communityPostViewModel.postCommentsList.observeAsState(emptyList())
    val postDetail by communityPostViewModel.communityPostDetail.observeAsState()

    val commentSize = postComments.size

    val emptyEntity = CommunityPostEntity(
        id = 1,
        userName = "눈송이",
        userDistrict = "용산구 청파동1가",
        postDistrict = "용산구 청파동1가",
        isResident = true,
        title = "숙대 짱인듯",
        content = "암튼 짱",
        postTime = 2,
        like = 10,
        view = 150,
        comment = 3
    )

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
        contentWindowInsets = WindowInsets(0, 0, 0, 0)

    ) { paddingValues ->

        Column(modifier = Modifier
            .fillMaxSize()
            .padding(paddingValues)
        ) {
            LazyColumn(modifier = Modifier.weight(1f).imeNestedScroll()
            ) {
                item {
                    CommunityPostDetailItem(
                        postDetail ?: emptyEntity,
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
                        text = "댓글 ${commentSize}",
                        style = b3Bold
                    )
                }

                items(postComments) { item ->
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
                                    //communityPostViewModel.postComment(content, postId) - 서버 문제로 연동 중단
                                    content = ""
                                    focusManager.clearFocus()
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
        communityPostViewModel = viewModel(),
        postId = 1,
        communityDistrict = "용산구 청파로2가"
    )
}