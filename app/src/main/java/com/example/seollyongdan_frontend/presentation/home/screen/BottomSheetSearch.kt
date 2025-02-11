package com.example.seollyongdan_frontend.presentation.home.screen

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.seollyongdan_frontend.presentation.auth.screen.LoginScreen
import com.example.seollyongdan_frontend.ui.theme.Gray900
import com.example.seollyongdan_frontend.ui.theme.SeollyongdanfrontendTheme
import com.example.seollyongdan_frontend.ui.theme.White
import com.example.seollyongdan_frontend.ui.theme.h6Regular
import com.example.seollyongdan_frontend.ui.theme.h6Semi
import com.naver.maps.geometry.LatLng
import com.naver.maps.map.CameraPosition
import com.naver.maps.map.compose.ExperimentalNaverMapApi
import com.naver.maps.map.compose.rememberCameraPositionState

@OptIn(ExperimentalMaterial3Api::class, ExperimentalNaverMapApi::class)
@Composable
fun BottomSheetSearch(
    onDismiss: () -> Unit,
    onMoveCamera : (LatLng) -> Unit,
    onSelectDistrict : (String) -> Unit
) {
    val cameraPositionState = rememberCameraPositionState {
        position = CameraPosition(LatLng(37.5663, 126.9779), 13.0)
    }
    val sheetState = rememberModalBottomSheetState(skipPartiallyExpanded = true)
    val coroutineScope = rememberCoroutineScope()
    var selectedDistrict by remember { mutableStateOf("성북구") }
    val districtLocations = mapOf(
        "강남구" to LatLng(37.5172, 127.0473),
        "강동구" to LatLng(37.5273, 127.1258),
        "강북구" to LatLng(37.6395, 127.0277),
        "강서구" to LatLng(37.5481, 126.8516),
        "관악구" to LatLng(37.4753, 126.9538),
        "광진구" to LatLng(37.5357, 127.0845),
        "구로구" to LatLng(37.4926, 126.8895),
        "금천구" to LatLng(37.4491, 126.9041),
        "노원구" to LatLng(37.6514, 127.0583),
        "도봉구" to LatLng(37.6658, 127.0495),
        "동대문구" to LatLng(37.5716, 127.0421),
        "동작구" to LatLng(37.5096, 126.9415),
        "마포구" to LatLng(37.5665, 126.9013),
        "서대문구" to LatLng(37.5763, 126.9388),
        "서초구" to LatLng(37.4807, 127.0348),
        "성동구" to LatLng(37.5763, 127.039),
        "성북구" to LatLng(37.5606, 127.0164),
        "송파구" to LatLng(37.5117, 127.1079),
        "양천구" to LatLng(37.5142, 126.8687),
        "영등포구" to LatLng(37.5236, 126.8983),
        "용산구" to LatLng(37.5360, 126.90675),
        "은평구" to LatLng(37.5999, 126.9312),
        "종로구" to LatLng(37.5703, 126.9816),
        "중구" to LatLng(37.5610, 126.9996),
        "중랑구" to LatLng(37.6038, 126.0947),
    )

    ModalBottomSheet(
        onDismissRequest = {
            onDismiss()
        },
        sheetState = sheetState,
        containerColor = White
    ) {
        LazyColumn(
            modifier = Modifier
                .padding(16.dp)
                .fillMaxWidth()
        ) {
            item {
                Text(
                    text ="지역 선택",
                    style = h6Semi
                )
            }
            item {
                Spacer(modifier = Modifier.height(8.dp))
            }
            districtLocations.keys.forEach { district ->
                item {
                    TextButton(
                        onClick = {
                            districtLocations[district]?.let { location ->
                                onMoveCamera(location)
                                onSelectDistrict(district)
                            }
                        },
                        modifier = Modifier
                            .padding(vertical = 4.dp)
                    ) {
                        Text(
                            text = district,
                            style = h6Regular,
                            color = Gray900
                            )
                    }
                }
            }
        }
    }
}

