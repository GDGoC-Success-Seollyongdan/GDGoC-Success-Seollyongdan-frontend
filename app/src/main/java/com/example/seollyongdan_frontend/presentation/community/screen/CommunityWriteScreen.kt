package com.example.seollyongdan_frontend.presentation.community.screen

import android.net.Uri
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import coil.compose.rememberAsyncImagePainter
import com.example.seollyongdan_frontend.R
import com.example.seollyongdan_frontend.presentation.community.navigation.CommunityNavigator
import com.example.seollyongdan_frontend.ui.component.ContentTextField
import com.example.seollyongdan_frontend.ui.component.PostButton
import com.example.seollyongdan_frontend.ui.theme.Gray100
import com.example.seollyongdan_frontend.ui.theme.Info400
import com.example.seollyongdan_frontend.ui.theme.White
import com.example.seollyongdan_frontend.ui.theme.h3Semi
import com.example.seollyongdan_frontend.ui.theme.h4Semi

@Composable
fun CommunityWriteRoute(
    navigator: CommunityNavigator,
    district: String
) {
    val communityPostViewModel: CommunityPostViewModel = hiltViewModel()

//지역 보내주기
    CommunityWriteScreen(
        onBackClick = { navigator.navigateBack() },
        onPostClick = { navigator.navigateToCommunity() },
        district = district
    )

}


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CommunityWriteScreen(
    onBackClick: () -> Unit,
    onPostClick: () -> Unit,
    district: String
) {
    var title by remember { mutableStateOf("") }
    var content by remember { mutableStateOf("") }
    var imageUri by remember { mutableStateOf<Uri?>(null) }
    val galleryLauncher = rememberLauncherForActivityResult(
        contract = ActivityResultContracts.GetContent(),
        onResult = {
            it?.let { imageUri = it }
        }
    )



    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text("글 작성하기", style = h3Semi)
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

            Spacer(modifier = Modifier.height(30.dp))

            Text(district, style = h4Semi, color = Info400)

            Spacer(modifier = Modifier.height(25.dp))


            if (imageUri != null) {
                Image(
                    modifier = Modifier
                        .size(135.dp)
                        .clip(RoundedCornerShape(40.dp))
                        .align(Alignment.CenterHorizontally)
                        .clickable { galleryLauncher.launch("image/*") },
                    painter = rememberAsyncImagePainter(model = imageUri),
                    contentDescription = null,
                    contentScale = ContentScale.FillBounds
                )
            } else {
                Box(
                    modifier = Modifier
                        .size(135.dp)
                        .background(
                            color = Gray100,
                            shape = RoundedCornerShape(40.dp)
                        )
                        .align(Alignment.CenterHorizontally)
                        .clickable { galleryLauncher.launch("image/*") }
                ) {
                    Image(
                        modifier = Modifier.align(Alignment.Center),
                        imageVector = ImageVector.vectorResource(id = R.drawable.ic_camera),
                        contentDescription = null,
                    )
                }
            }

            Spacer(modifier = Modifier.height(25.dp))



            ContentTextField(
                value = title,
                onValueChange = { title = it },
                placeholderText = "제목을 입력해주세요.",
                height = 20
            )

            Spacer(modifier = Modifier.height(20.dp))

            ContentTextField(
                value = content,
                onValueChange = { content = it },
                placeholderText = "내용을 입력해주세요.",
                height = 240
            )

            Spacer(modifier = Modifier.weight(1f))

            PostButton(
                value = "등록",
                onClick = onPostClick
            )

            Spacer(modifier = Modifier.height(20.dp))


        }

    }


}

@Preview
@Composable
fun WriteScreenPreview(){
    CommunityWriteScreen(
        onBackClick = {},
        onPostClick = {},
        district = "용산구 청파로2가"
    )
}