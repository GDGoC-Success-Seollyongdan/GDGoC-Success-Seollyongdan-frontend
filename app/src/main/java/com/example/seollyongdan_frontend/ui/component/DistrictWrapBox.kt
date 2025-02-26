package com.example.seollyongdan_frontend.ui.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.seollyongdan_frontend.presentation.home.screen.townIdToTownName
import com.example.seollyongdan_frontend.ui.theme.Info200
import com.example.seollyongdan_frontend.ui.theme.Info400
import com.example.seollyongdan_frontend.ui.theme.Primary600
import com.example.seollyongdan_frontend.ui.theme.Warning100
import com.example.seollyongdan_frontend.ui.theme.b1Semi

@Composable
fun DistrictWrapBox(
    townId : Int,
    type : String
) {
    val townName = townIdToTownName(townId)

    val color = when(type){
        "높음" -> Info200
        "낮음" -> Primary600
        else -> Warning100

    }

    Box(modifier = Modifier
        .height(31.dp)
        .wrapContentWidth()
        .clip(RoundedCornerShape(20.dp))
        .background(color),
        contentAlignment = Alignment.Center
    ){
        Text(townName, style = b1Semi, modifier = Modifier.padding(horizontal = 15.dp))
    }
}

@Preview
@Composable
fun DistrictWrapBoxPreview(){
    DistrictWrapBox(
        townId = 24,
        type = "낮음"
    )


}