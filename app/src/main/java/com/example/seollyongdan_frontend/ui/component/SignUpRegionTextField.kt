package com.example.seollyongdan_frontend.ui.component

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.seollyongdan_frontend.presentation.auth.screen.RegionSearchBottomSheet
import com.example.seollyongdan_frontend.ui.theme.Gray200
import com.example.seollyongdan_frontend.ui.theme.Gray50
import com.example.seollyongdan_frontend.ui.theme.b3Regular
import com.example.seollyongdan_frontend.ui.theme.h6Regular
import com.example.seollyongdan_frontend.ui.theme.h7Semi

@Composable
fun SignUpRegionTextField(
    modifier: Modifier = Modifier,
    value: String,
    onValueChange: (String) -> Unit,
    title: String,
    placeholderText: String,
    showWarning: Boolean,
    selectedRegion: (String) -> Unit,  // 외부에서 selectedRegion을 처리
    regions: List<String>,
    isBottomSheetVisible: Boolean,  // 바텀시트 상태 관리
    onBottomSheetVisibilityChange: (Boolean) -> Unit,  // 바텀시트 상태 변경 함수
    textAlign: TextAlign = TextAlign.Start
) {
    val warningMessage = "동네를 설정해주세요"

    Column {
        Text(title, style = h7Semi)

        Spacer(modifier = Modifier.height(8.dp))

        OutlinedTextField(
            modifier = modifier
                .height(50.dp)
                .clickable {
                    onBottomSheetVisibilityChange(true)  // 바텀시트 열기
                },
            value = value,
            onValueChange = onValueChange,
            readOnly = true,
            placeholder = {
                Text(
                    modifier = Modifier.fillMaxWidth(),
                    text = placeholderText,
                    style = h7Semi,
                    color = Gray200,
                    textAlign = textAlign
                )
            },
            textStyle = h6Regular.copy(textAlign = textAlign),
            shape = RoundedCornerShape(10.dp),
            colors = OutlinedTextFieldDefaults.colors(
                focusedContainerColor = Gray50,
                unfocusedContainerColor = Gray50,
                focusedBorderColor = Gray50,
                unfocusedBorderColor = Gray50
            )
        )

        Spacer(modifier = Modifier.height(11.dp))

        if (showWarning) {
            Text(
                warningMessage,
                style = b3Regular,
                color = Color.Red,
                modifier = Modifier.align(Alignment.CenterHorizontally)
            )
        }

        // 바텀시트가 표시될 때
        if (isBottomSheetVisible) {
            RegionSearchBottomSheet(
                onDismiss = { onBottomSheetVisibilityChange(false) },  // 바텀시트 닫기
                onItemSelected = { address ->
                    selectedRegion(address)  // 선택된 지역을 외부로 전달
                    onBottomSheetVisibilityChange(false)  // 바텀시트 닫기
                },
                regions = regions  // regions를 바텀시트로 전달
            )
        }
    }
}
@Preview(showBackground = true)
@Composable
fun SignUpRegionTextFieldPreview() {
    SignUpRegionTextField(
        value = "",
        onValueChange = {},
        title = "내 동네 설정하기",
        placeholderText = "동명으로 검색 (ex. 청파동)",
        showWarning = true,
        selectedRegion = { },  // 지역 선택 시 selectedRegion 업데이트
        regions = listOf("청파동"),  // "시 구 동" 형식으로 지역 목록 전달
        isBottomSheetVisible = true,  // 바텀시트 상태 전달
        onBottomSheetVisibilityChange = {  }  // 바텀시트 상태 업데이트 함수 전달
    )
}