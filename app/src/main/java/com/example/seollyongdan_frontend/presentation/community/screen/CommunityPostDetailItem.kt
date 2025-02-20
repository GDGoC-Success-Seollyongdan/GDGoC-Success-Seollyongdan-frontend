package com.example.seollyongdan_frontend.presentation.community.screen

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.seollyongdan_frontend.ui.component.CommunityProfileBox
import com.example.seollyongdan_frontend.ui.theme.Gray900
import com.example.seollyongdan_frontend.ui.theme.Info400
import com.example.seollyongdan_frontend.ui.theme.h5Bold
import com.example.seollyongdan_frontend.ui.theme.h6Regular

@Composable
fun CommunityPostDetailItem(
    data: CommunityPostEntity,
    communityDistrict: String
) {
    val isFavorite = remember { mutableStateOf(false) }

    Column(
        modifier = Modifier
            .wrapContentHeight()
            .fillMaxWidth()
            .padding(horizontal = 24.dp)
    ) {
        CommunityProfileBox(
            communityDistrict = communityDistrict,
            userDistrict = data.userDistrict,
            userName = data.userName,
            isResident = data.isResident,
            time = data.postTime
        )

        Spacer(modifier = Modifier.height(20.dp))

        Text(data.title, style = h5Bold)

        Spacer(modifier = Modifier.height(20.dp))

        Text(data.content, style = h6Regular)

        Spacer(modifier = Modifier.height(20.dp))

        Row() {
            IconButton(
                modifier = Modifier
                    .size(18.dp)
                    .padding(top = 3.dp),

                onClick = {
                    isFavorite.value = !isFavorite.value
                }) {
                Icon(
                    imageVector = if (isFavorite.value) Icons.Default.Favorite else Icons.Default.FavoriteBorder,
                    contentDescription = "공감",
                    tint = if (isFavorite.value) Info400 else Gray900
                )
            }

            Spacer(modifier = Modifier.width(10.dp))

            Text("공감 ${data.like}")

            Spacer(modifier = Modifier.width(10.dp))

            Text("조회 ${data.view}")
        }
    }

}

@Preview
@Composable
fun PostDetailItemPreview() {
    val data =
        CommunityPostEntity(
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
            comment = 3,
        )
    CommunityPostDetailItem(
        data, "용산구 청파로1가"
    )
}