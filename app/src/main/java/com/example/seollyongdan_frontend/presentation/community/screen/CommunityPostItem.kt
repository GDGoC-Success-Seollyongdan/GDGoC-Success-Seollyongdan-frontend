package com.example.seollyongdan_frontend.presentation.community.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.seollyongdan_frontend.ui.theme.Info400
import com.example.seollyongdan_frontend.ui.theme.White
import com.example.seollyongdan_frontend.ui.theme.b3Regular
import com.example.seollyongdan_frontend.ui.theme.b3Semi
import com.example.seollyongdan_frontend.ui.theme.h6Semi
import com.example.seollyongdan_frontend.ui.theme.h7Regular
import com.example.seollyongdan_frontend.ui.theme.h7Semi

@Composable
fun CommunityPostItem(
    data: CommunityPostEntity,
    onClick : () -> Unit,
    selectedRegion : String
) {
    Box(
        modifier = Modifier
            .width(371.dp)
            .wrapContentHeight()
            .clip(RoundedCornerShape(10.dp))
            .background(White)
            .clickable {
                onClick
            }
    ) {
        Column(
            modifier = Modifier
                .padding(horizontal = 15.dp, vertical = 10.dp)
        ) {
            Row {
                Text(data.userName, style = h7Semi)

                if (data.isResident && data.userDistrict == selectedRegion) {

                    Spacer(modifier = Modifier.width(10.dp))

                    Box(
                        modifier = Modifier
                            .width(50.dp)
                            .height(20.dp)
                            .clip(RoundedCornerShape(20.dp))
                            .background(Info400),
                        contentAlignment = Alignment.Center
                    ) {
                        Text("거주자", style = b3Semi, color = White)
                    }
                }
            }

            Spacer(modifier = Modifier.height(20.dp))

            Text(data.title, style = h6Semi)

            Spacer(modifier = Modifier.height(10.dp))

            Text(data.content, style = h7Regular)

            Spacer(modifier = Modifier.height(25.dp))

            Row {
                Text("${data.postTime}시간 전", style = b3Regular)

                Spacer(modifier = Modifier.width(10.dp))

                Text("공감 ${data.like}", style = b3Regular)


                Spacer(modifier = Modifier.width(10.dp))


                Text("조회 ${data.view}", style = b3Regular)

            }


        }
    }

}

@Preview
@Composable
fun CommunityPostItemPreview(){
    val data = CommunityPostEntity(
        id = 1,
        userName = "김눈송",
        userDistrict = "마포구",
        postDistrict = "마포구",
        isResident = true,
        title = "공덕동 맛집 추천드려요",
        content = "OOO 고깃집 맛있어요!OOO 고깃집 맛있어요!OOO 고깃집 맛있어요!OOO 고깃집 맛있어요!OOO 고깃집 맛있어요!OOO 고깃집 맛있어요!OOO 고깃집 맛있어요!OOO 고깃집 맛있어요!OOO 고깃집 맛있어요!OOO 고깃집 맛있어요!OOO 고깃집 맛있어요!",
        postTime = 2,
        like = 3,
        view = 38,
        comment = 3
    )

    CommunityPostItem(
        data, onClick = {}, selectedRegion = "용산구 청파동1가"
    )
}