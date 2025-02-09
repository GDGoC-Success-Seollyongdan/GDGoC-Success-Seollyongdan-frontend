package com.example.seollyongdan_frontend.ui.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.seollyongdan_frontend.R
import com.example.seollyongdan_frontend.ui.theme.Gray400
import com.example.seollyongdan_frontend.ui.theme.Gray50
import com.example.seollyongdan_frontend.ui.theme.Gray900
import com.example.seollyongdan_frontend.ui.theme.h5Semi
import com.example.seollyongdan_frontend.ui.theme.h7Regular

@Composable
fun HomeButton(
    imageId : Int,
    value1 : String,
    value2 : String,
    onClick : () -> Unit
) {
    Button(
        modifier = Modifier
            .fillMaxWidth()
            .height(87.dp),
        shape = RoundedCornerShape(15.dp),
        onClick = onClick,
        colors = ButtonDefaults.buttonColors(Gray50)
    ) {
        Row(
            modifier = Modifier
                .fillMaxSize(),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Box(
                modifier = Modifier
                    .size(60.dp)
            ) {
                Image(
                    painter = painterResource(id = imageId),
                    contentDescription = "컴포넌트 이미지"
                )
            }
            Spacer(
                modifier = Modifier.padding(end = 20.dp)
            )
            Column(
                modifier = Modifier
                    .fillMaxSize(),
                verticalArrangement = Arrangement.Center
            ) {
                Text(
                    text = value1,
                    style = h7Regular,
                    color = Gray400
                )
                Text(
                    text = value2,
                    style = h5Semi,
                    color = Gray900
                )
            }
        }
    }
}

@Preview
@Composable
fun HomeButtonPreview() {
    HomeButton(
        imageId = R.drawable.ic_home_life,
        value1 = "범죄 발생 빈도를 알고 싶다면",
        value2 = "안전 및 치안",
        onClick = {}
    )
}