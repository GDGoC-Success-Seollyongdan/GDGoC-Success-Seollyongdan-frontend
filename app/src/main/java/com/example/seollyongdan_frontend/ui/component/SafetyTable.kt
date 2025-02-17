package com.example.seollyongdan_frontend.ui.component

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Text
import androidx.compose.material3.VerticalDivider
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.seollyongdan_frontend.ui.theme.Gray100
import com.example.seollyongdan_frontend.ui.theme.Gray200
import com.example.seollyongdan_frontend.ui.theme.Gray300
import com.example.seollyongdan_frontend.ui.theme.Gray900
import com.example.seollyongdan_frontend.ui.theme.White
import com.example.seollyongdan_frontend.ui.theme.b4Regular
import com.example.seollyongdan_frontend.ui.theme.b4Semi

@Composable
fun SafetyTable(
    data: List<String>
) {
    val tableData = listOf(
        listOf("시설명", "개수"), // 헤더
        listOf("CCTV", data[0]),
        listOf("경찰서", data[1]),
        listOf("소방서", data[2])
    )

    Column(
        modifier = Modifier
            .width(310.dp)
            .height(144.dp)
            .clip(RoundedCornerShape(8.dp))
            .background(Color.White)
            .border(1.dp, Gray200, RoundedCornerShape(5.dp))
    ) {
        tableData.forEachIndexed { rowIndex, row ->
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(if (rowIndex == 0) Gray100 else White)

            ) {
                row.forEachIndexed { cellIndex, cell ->
                    Text(
                        text = cell,
                        style = (if (rowIndex == 0) b4Semi else b4Regular),
                        modifier = Modifier
                            .width(155.dp)
                            .height(36.dp)
                            .padding(horizontal = 10.dp, vertical = 10.dp),
                        textAlign = TextAlign.Start,
                        color = Gray900
                    )

                    // 마지막 열이 아니면 세로줄 추가
                    if (cellIndex < row.size - 1) {
                        VerticalDivider(
                            color = Gray300,
                            modifier = Modifier
                                .width(1.dp)
                                .height(36.dp)
                        )
                    }
                }
            }
            HorizontalDivider() // 가로줄
        }
    }
}


@Preview
@Composable
fun SafetyTablePreview() {
    val data = listOf("100", "200", "300")
    SafetyTable(data)
}