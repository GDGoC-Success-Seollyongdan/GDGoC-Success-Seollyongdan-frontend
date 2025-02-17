package com.example.seollyongdan_frontend.ui.component

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.seollyongdan_frontend.ui.theme.Danger800
import com.example.seollyongdan_frontend.ui.theme.GraphBlue
import com.example.seollyongdan_frontend.ui.theme.GraphBrown
import com.example.seollyongdan_frontend.ui.theme.GraphGreen
import com.example.seollyongdan_frontend.ui.theme.GraphOrange
import com.example.seollyongdan_frontend.ui.theme.GraphPink
import com.example.seollyongdan_frontend.ui.theme.GraphPurple
import com.example.seollyongdan_frontend.ui.theme.Gray700
import com.example.seollyongdan_frontend.ui.theme.b3Semi
import com.example.seollyongdan_frontend.ui.theme.b4Regular

@Composable
fun PieGraph(
    data: List<Float>,
    labels: List<String>,
    modifier: Modifier = Modifier,
    colors: List<Color> = listOf(
        GraphBlue,
        GraphPink,
        GraphBrown,
        GraphGreen,
        GraphOrange,
        GraphPurple
    )
) {
    Column(
        modifier = modifier
            .fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text("상위 5위", color = Gray700, style = b3Semi)

        Canvas(
            modifier = Modifier
                .size(200.dp)
                .padding(8.dp)
        ) {
            val total = data.sum()
            var startAngle = 0f

            data.forEachIndexed { index, value ->
                val sweepAngle = (value / total) * 360f

                val path = Path().apply {
                    moveTo(center.x, center.y)
                    arcTo(
                        rect = androidx.compose.ui.geometry.Rect(
                            0f,
                            0f,
                            size.width,
                            size.height
                        ),
                        startAngle,
                        sweepAngle,
                        forceMoveTo = false
                    )
                    close()
                }

                drawPath(
                    path,
                    color = colors[index % colors.size]
                )

                startAngle += sweepAngle
            }
        }

        // Legend
        LazyRow(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 16.dp),
            horizontalArrangement = Arrangement.Center
        ) {
            items(labels.size) { index ->
                Row(
                    modifier = Modifier.padding(horizontal = 8.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Box(
                        modifier = Modifier
                            .size(12.dp)
                            .background(colors[index % colors.size])
                    )
                    Spacer(modifier = Modifier.width(4.dp))
                    Text(
                        text = labels[index],
                        color = Gray700,
                        style = b4Regular
                    )
                }
            }
        }
    }
}

@Preview
@Composable
fun PieGraphPreview(){
    val pieData = listOf(30f, 20f, 15f, 10f, 15f, 10f)
    val pieLabels = listOf("A사", "B사", "C사", "D사", "E사", "F사")
    PieGraph(data = pieData, labels = pieLabels)
}