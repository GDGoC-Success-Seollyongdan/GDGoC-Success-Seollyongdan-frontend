package com.example.seollyongdan_frontend.ui.component

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.seollyongdan_frontend.R
import com.example.seollyongdan_frontend.ui.theme.Success900
import com.example.seollyongdan_frontend.ui.theme.White
import com.example.seollyongdan_frontend.ui.theme.b4Semi
import com.example.seollyongdan_frontend.ui.theme.h7Bold


@Composable
fun MainToVisualizationButton(
    onClick: () -> Unit,
    text: String
) {
    Box(
        modifier = Modifier
            .width(249.dp)
            .height(54.dp)
            .clip(RoundedCornerShape(10.dp))
            .background(Success900)
            .clickable(onClick = onClick),
        contentAlignment = Alignment.TopStart
    ) {

        Row(modifier = Modifier.padding(horizontal =13.dp, vertical = 8.dp)) {
            Column(
                modifier = Modifier
                    .weight(1f)
            ) {
                Text("한 눈에 보는", style = b4Semi, color = White)
                Spacer(modifier = Modifier.height(5.dp))
                Text(text, style = h7Bold, color = White)
            }


            Icon(
                modifier = Modifier.padding(top = 5.dp, end = 10.dp),
                imageVector = ImageVector.vectorResource(id = R.drawable.ic_go),
                contentDescription = "이전으로 돌아가기",
                tint = Color.Unspecified // 원본 색상 유지
            )


        }


    }
}


@Preview
@Composable
fun MainToVisualizationButtonPreview() {
    MainToVisualizationButton(
        onClick = {},
        text = "서울시 구별 범죄 발생 빈도"
    )
}