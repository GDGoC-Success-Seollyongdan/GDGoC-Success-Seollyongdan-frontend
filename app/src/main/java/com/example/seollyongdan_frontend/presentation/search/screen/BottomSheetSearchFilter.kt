package com.example.seollyongdan_frontend.presentation.search.screen

import android.widget.Space
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.Slider
import androidx.compose.material3.SliderDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.runtime.mutableFloatStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.seollyongdan_frontend.presentation.search.navigation.SearchNavigator
import com.example.seollyongdan_frontend.ui.theme.Gray100
import com.example.seollyongdan_frontend.ui.theme.Info400
import com.example.seollyongdan_frontend.ui.theme.Primary900
import com.example.seollyongdan_frontend.ui.theme.White
import com.example.seollyongdan_frontend.ui.theme.b2Regular
import com.example.seollyongdan_frontend.ui.theme.h4Semi
import com.example.seollyongdan_frontend.ui.theme.h5Semi
import com.google.accompanist.systemuicontroller.rememberSystemUiController

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun BottomSheetSearchFilter(
    onDismiss : () -> Unit,
    onClickToSearchResult: () -> Unit
) {
    var sliderPosition1 = remember { mutableFloatStateOf(0f) }
    var sliderPosition2 = remember { mutableFloatStateOf(0f) }
    var sliderPosition3 = remember { mutableFloatStateOf(0f) }
    var sliderPosition4 = remember { mutableFloatStateOf(0f) }


    ModalBottomSheet(
        onDismissRequest = { onDismiss() },
        modifier = Modifier.background(color = White)
    ) {
        Column(
            modifier = Modifier
                .background(color = White)
                .padding(16.dp),
        ) {
            Text(
                "동네 추천 필터",
                style = h5Semi,
                color = Primary900
            )
            Spacer(modifier = Modifier.height(16.dp))
            Spacer(
                modifier = Modifier
                    .height(1.dp)
                    .fillMaxWidth()
                    .background(color = Primary900)
            )
            Spacer(modifier = Modifier.height(16.dp))
            Text(
                "안전 및 치안",
                style = h5Semi,
                color = Primary900
            )
            Slider(
                value = sliderPosition1.value,
                onValueChange = { sliderPosition1.value = it },
                colors = SliderDefaults.colors(
                    thumbColor = Primary900,
                    activeTrackColor = Primary900,
                    inactiveTrackColor = Gray100,
                ),
                steps = 1,
                valueRange = 0f..2f
            )
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text(text = "상관없음", style = b2Regular, color = Primary900)
                Text(text = "중요", style = b2Regular, color = Primary900)
                Text(text = "매우 중요", style = b2Regular, color = Primary900)
            }
            Spacer(modifier = Modifier.height(16.dp))
            Text(
                "교통",
                style = h5Semi,
                color = Primary900
            )
            Slider(
                value = sliderPosition2.value,
                onValueChange = { sliderPosition2.value = it },
                colors = SliderDefaults.colors(
                    thumbColor = Primary900,
                    activeTrackColor = Primary900,
                    inactiveTrackColor = Gray100,
                ),
                steps = 1,
                valueRange = 0f..2f
            )
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text(text = "상관없음", style = b2Regular, color = Primary900)
                Text(text = "중요", style = b2Regular, color = Primary900)
                Text(text = "매우 중요", style = b2Regular, color = Primary900)
            }
            Spacer(modifier = Modifier.height(16.dp))
            Text(
                "부동산",
                style = h5Semi,
                color = Primary900
            )
            Slider(
                value = sliderPosition3.value,
                onValueChange = { sliderPosition3.value = it },
                colors = SliderDefaults.colors(
                    thumbColor = Primary900,
                    activeTrackColor = Primary900,
                    inactiveTrackColor = Gray100,
                ),
                steps = 1,
                valueRange = 0f..2f
            )
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text(text = "상관없음", style = b2Regular, color = Primary900)
                Text(text = "중요", style = b2Regular, color = Primary900)
                Text(text = "매우 중요", style = b2Regular, color = Primary900)
            }
            Spacer(modifier = Modifier.height(16.dp))
            Text(
                "생활/편의시설",
                style = h5Semi,
                color = Primary900
            )
            Slider(
                value = sliderPosition4.value,
                onValueChange = { sliderPosition4.value = it },
                colors = SliderDefaults.colors(
                    thumbColor = Primary900,
                    activeTrackColor = Primary900,
                    inactiveTrackColor = Gray100,
                ),
                steps = 1,
                valueRange = 0f..2f
            )
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text(text = "상관없음", style = b2Regular, color = Primary900)
                Text(text = "중요", style = b2Regular, color = Primary900)
                Text(text = "매우 중요", style = b2Regular, color = Primary900)
            }
            Spacer(modifier = Modifier.height(30.dp))
            Button(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(67.dp),
                shape = RoundedCornerShape(10.dp),
                onClick = onClickToSearchResult ,
                colors = ButtonDefaults.buttonColors(
                    containerColor = Primary900
                ),
                contentPadding = PaddingValues(vertical = 10.dp),

                ){
                Text(
                    text = "적용하기",
                    style = h4Semi,
                    color = White
                )

            }
        }
    }
}
