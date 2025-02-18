package com.example.seollyongdan_frontend.ui.component

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.seollyongdan_frontend.ui.theme.Success700
import com.example.seollyongdan_frontend.ui.theme.VisualizationGreen
import com.example.seollyongdan_frontend.ui.theme.VisualizationRed
import com.example.seollyongdan_frontend.ui.theme.VisualizationYellow
import com.example.seollyongdan_frontend.ui.theme.White
import com.example.seollyongdan_frontend.ui.theme.b3Semi

@Composable
fun VisualizationState(
    text1: String,
    text2: String,
    text3: String
) {

    Box(
        modifier = Modifier
            .height(72.dp)
            .width(158.dp)
            .clip(RoundedCornerShape(10.dp))
            .background(White)
            .border(1.dp, color = Success700, RoundedCornerShape(10.dp))

    ) {
        Column(modifier = Modifier.fillMaxSize()
            .padding(top = 8.dp, start = 10.dp)) {
            DetailRow(VisualizationGreen, text1)

            Spacer(modifier = Modifier.height(5.dp))


            DetailRow(VisualizationYellow, text2)

            Spacer(modifier = Modifier.height(5.dp))

            DetailRow(VisualizationRed, text3)

        }

    }

}

@Composable
fun DetailRow(
    color: Color,
    text: String
) {
    Row() {

        Box(
            modifier = Modifier
                .size(12.dp)
                .clip(RoundedCornerShape(100.dp))
                .background(color)
                .border(1.dp, color = Success700, RoundedCornerShape(100.dp))

        )

        Spacer(modifier = Modifier.width(8.dp))

        Text(text, style = b3Semi)

    }

}

@Preview
@Composable
fun VisualizationStatePreview(){
    VisualizationState(
        text1 = "낮은 편이에요",
        text2 = "보통이에요",
        text3 = "높은 편이에요"
    )
}