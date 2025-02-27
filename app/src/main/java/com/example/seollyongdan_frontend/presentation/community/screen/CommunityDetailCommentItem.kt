package com.example.seollyongdan_frontend.presentation.community.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.seollyongdan_frontend.data.dto.response.ResponseCommunityPostCommentDto
import com.example.seollyongdan_frontend.ui.component.CommunityCommentProfileBox
import com.example.seollyongdan_frontend.ui.component.CommunityProfileBox
import com.example.seollyongdan_frontend.ui.theme.Gray100
import com.example.seollyongdan_frontend.ui.theme.b2Regular

@Composable
fun CommunityDetailCommentItem(
    data: ResponseCommunityPostCommentDto,
    communityDistrict: String
) {
    Column {

        Column(
            modifier = Modifier
                .padding(horizontal = 24.dp)
                .padding(top = 10.dp)

        ) {

            CommunityCommentProfileBox(
                communityDistrict = communityDistrict,
            )

            Spacer(modifier = Modifier.height(15.dp))

            Text(data.content, style = b2Regular, modifier = Modifier.padding(start = 60.dp))

        }

        Spacer(modifier = Modifier.height(15.dp))


        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(1.dp)
                .background(Gray100)
        )
    }

}

@Preview
@Composable
fun DetailCommentItemPreview() {
    val data =
        ResponseCommunityPostCommentDto(
            commentId = 1,
            content = "맞아요!",
        )
    CommunityDetailCommentItem(
        data, communityDistrict = "용산구 청파로2가"
    )
}