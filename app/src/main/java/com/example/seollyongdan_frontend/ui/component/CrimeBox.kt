package com.example.seollyongdan_frontend.ui.component

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.seollyongdan_frontend.ui.theme.h5Semi

@OptIn(ExperimentalLayoutApi::class)
@Composable
fun CrimeBox (
    list : List<Int>,
    type : String
) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .wrapContentHeight()
    ) {

        Text(
            text = when (type){
                "높음" -> "상위에 속해요"
                "낮음" -> "하위에 속해요"
                else -> "평균이에요"

            }, style = h5Semi
        )

        Spacer(modifier = Modifier.height(10.dp))

        FlowRow(
            modifier = Modifier
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(9.dp),
            verticalArrangement = Arrangement.spacedBy(8.dp),
            maxItemsInEachRow = 9
        ) {
            list.forEach { item ->
                DistrictWrapBox(
                    townId = item,
                    type = type
                )
            }
        }
    }
}

@Preview
@Composable
fun CrimeBoxPreview(){
    val list = listOf(1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24,25)
    CrimeBox(list, "평균")
}