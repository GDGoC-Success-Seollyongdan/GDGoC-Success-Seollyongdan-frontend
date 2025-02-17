package com.example.seollyongdan_frontend.ui.component

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.nativeCanvas
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.seollyongdan_frontend.ui.theme.GraphOrange
import com.example.seollyongdan_frontend.ui.theme.Gray700

@Composable
fun LineGraph(
    labels: List<String>,
    data: List<Float>
) {
    val lineColor = GraphOrange
    val textColor = Gray700

    Canvas(
        modifier = Modifier
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
        val minValue = data.minOrNull() ?: 0f
        val range = maxValue - minValue

        // Y축 값 범위 계산 및 표시
        val ySteps = 5  // Y축에 표시할 값의 개수
        val yStepSize = range / (ySteps - 1)
        for (i in 0 until ySteps) {
            val yValue = minValue + (yStepSize * i)
            val y = height - (i * height / (ySteps - 1))

            // Y축 눈금 선
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
                        color = textColor.toArgb()
                        textSize = 30f
                        textAlign = android.graphics.Paint.Align.RIGHT
                    }
                )
            }
        }

        // X축 레이블 표시
        labels.forEachIndexed { index, label ->
            val x = (index.toFloat() / (labels.size - 1)) * width
            drawContext.canvas.nativeCanvas.apply {
                drawText(
                    label,
                    x,
                    height + 35f,  // Y 위치 (아래쪽 여백)
                    android.graphics.Paint().apply {
                        color = textColor.toArgb()
                        textSize = 30f
                        textAlign = android.graphics.Paint.Align.CENTER
                    }
                )
            }
        }

        // 그래프 축 그리기
        drawLine(
            Gray700,
            Offset(0f, height),
            Offset(width, height),
            strokeWidth = 2f
        )
        drawLine(
            Gray700,
            Offset(0f, 0f),
            Offset(0f, height),
            strokeWidth = 2f
        )

        // 꺾은선 그래프 그리기
        val points = data.mapIndexed { index, value ->
            Offset(
                x = (index.toFloat() / (data.size - 1)) * width,
                y = height - ((value - minValue) / range) * height
            )
        }

        // 선 그리기
        for (i in 0 until points.size - 1) {
            drawLine(
                lineColor,
                points[i],
                points[i + 1],
                strokeWidth = 3f
            )
        }

        // 포인트 그리기
        points.forEach { point ->
            drawCircle(
                lineColor,
                radius = 5f,
                center = point
            )
        }
    }
}

@Preview
@Composable
fun LineGraphPreview() {
    val years = listOf("2013", "2014", "2015", "2016", "2017", "2018", "2019", "2020", "2021")
    val values = listOf(20f, 5f, 25f, 10f, 20f, 5f, 25f, 10f, 20f)
    LineGraph(years, values)
}