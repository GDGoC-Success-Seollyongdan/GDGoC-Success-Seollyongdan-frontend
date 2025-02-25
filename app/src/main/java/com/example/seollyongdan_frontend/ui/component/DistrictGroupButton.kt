package com.example.seollyongdan_frontend.ui.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.seollyongdan_frontend.R
import com.example.seollyongdan_frontend.ui.theme.Gray50
import com.example.seollyongdan_frontend.ui.theme.h5Semi

@Composable
fun DistrictGroupButton(
    image : Int,
    text : String,
    onClickToSearchResult: () -> Unit
) {

    Box(
        modifier = Modifier
            .fillMaxWidth()
            .background(color = Gray50, shape = RoundedCornerShape(15.dp))
            .padding(16.dp)
            .clickable { onClickToSearchResult() }
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically
        ) {
            Image(
                painter = painterResource(id = image),
                contentDescription = "지역구별 이미지",
                modifier = Modifier.size(50.dp)
            )
            Spacer(modifier = Modifier.width(24.dp))
            Text(
                text = text,
                style = h5Semi,
                color = Color.Black
            )
        }
    }
}

@Preview
@Composable
fun DistrictGroupButtonPreview() {
    DistrictGroupButton(
        image = R.drawable.ic_search_cup,
        text = "안정적이고 조화로운 주거환경",
        onClickToSearchResult = {}
    )
}