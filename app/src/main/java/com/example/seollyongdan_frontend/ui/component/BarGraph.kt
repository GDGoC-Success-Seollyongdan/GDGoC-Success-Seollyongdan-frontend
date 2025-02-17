package com.example.seollyongdan_frontend.ui.component

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.nativeCanvas
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.seollyongdan_frontend.ui.theme.GraphBlue
import com.example.seollyongdan_frontend.ui.theme.GraphBrown
import com.example.seollyongdan_frontend.ui.theme.GraphGreen
import com.example.seollyongdan_frontend.ui.theme.GraphOrange
import com.example.seollyongdan_frontend.ui.theme.GraphPink
import com.example.seollyongdan_frontend.ui.theme.Gray700

@Composable
fun BarGraph(
    data: List<Float>,
    labels: List<String>,
    modifier: Modifier = Modifier,
    barColors: List<Color> = listOf(
        GraphBlue,
        GraphPink,
        GraphBrown,
        GraphGreen,
        GraphOrange,
    )
) {
    Canvas(
        modifier = modifier
            .fillMaxWidth()
            .padding(
                start = 40.dp,  // y축 레이블을 위한 여백
                end = 16.dp,
                top = 16.dp,
                bottom = 40.dp  // x축 레이블을 위한 여백
            )
            .height(200.dp)
    ) {
        val width = size.width
        val height = size.height
        val maxValue = data.maxOrNull() ?: 0f
        val barWidth = (width - (data.size + 1) * 20f) / data.size  // 막대 사이 간격 20f

        // Y축 값 범위 계산 및 표시
        val ySteps = 5  // Y축에 표시할 값의 개수
        val yStepSize = maxValue / (ySteps - 1)
        for (i in 0 until ySteps) {
            val yValue = yStepSize * i
            val y = height - (i * height / (ySteps - 1))

            // Y축 구분선
            drawLine(
                color = Gray700.copy(alpha = 0.3f),
                start = Offset(0f, y),
                end = Offset(width, y),
                strokeWidth = 1f
            )

            // Y축 레이블
            drawContext.canvas.nativeCanvas.apply {
                drawText(
                    String.format("%.1f", yValue),
                    -35f,  // X 위치 (왼쪽 여백)
                    y + 5f,  // Y 위치
                    android.graphics.Paint().apply {
                        color = Gray700.toArgb()
                        textSize = 30f
                        textAlign = android.graphics.Paint.Align.RIGHT
                    }
                )
            }
        }

        // Draw Y axis
        drawLine(
            Gray700,
            Offset(0f, 0f),
            Offset(0f, height),
            strokeWidth = 2f
        )

        // Draw X axis
        drawLine(
            Gray700,
            Offset(0f, height),
            Offset(width, height),
            strokeWidth = 2f
        )

        // Draw bars and labels
        data.forEachIndexed { index, value ->
            val barHeight = (value / maxValue) * height
            val xPos = (index * (barWidth + 20f)) + 20f  // 첫 막대 앞에도 20f 간격

            // Draw bar
            drawRect(
                color = barColors[index % barColors.size],
                topLeft = Offset(
                    x = xPos,
                    y = height - barHeight
                ),
                size = Size(barWidth, barHeight)
            )

            // Draw label
            drawContext.canvas.nativeCanvas.apply {
                drawText(
                    labels[index],
                    xPos + (barWidth / 2),
                    height + 35f,  // 레이블 위치
                    android.graphics.Paint().apply {
                        color = Gray700.toArgb()
                        textSize = 30f
                        textAlign = android.graphics.Paint.Align.CENTER
                    }
                )
            }
        }
    }
}

@Preview
@Composable
fun BarGraphPreview() {
    val data = listOf(50f, 30f, 70f, 40f, 60f)
    val labels = listOf("A사", "B사", "C사", "D사", "E사")
    BarGraph(data = data, labels = labels)
}