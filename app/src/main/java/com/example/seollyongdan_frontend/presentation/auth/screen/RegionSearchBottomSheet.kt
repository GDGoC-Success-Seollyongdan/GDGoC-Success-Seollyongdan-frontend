package com.example.seollyongdan_frontend.presentation.auth.screen

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun RegionSearchBottomSheet(
    onDismiss: () -> Unit,
    onItemSelected: (String) -> Unit,
    regions: List<String>
) {
    var searchQuery by remember { mutableStateOf("") }

    val filteredRegions = regions.filter {it.contains(searchQuery, ignoreCase = true)}

    //val filteredRegions = remember(searchQuery, regions) {
    //    regions.filter { it.contains(searchQuery, ignoreCase = true) }
    //}

    ModalBottomSheet(onDismissRequest = onDismiss) {
        Column(modifier = Modifier.padding(16.dp)) {
            TextField(
                value = searchQuery,
                onValueChange = { searchQuery = it },
                label = { Text("주소 검색") },
                modifier = Modifier.fillMaxWidth()
            )

            LazyColumn {
                items(filteredRegions) { region ->
                    Text(
                        text = region,
                        modifier = Modifier
                            .fillMaxWidth()
                            .clickable {
                                onItemSelected(region)  // 지역 선택 시 호출
                                onDismiss()  // 바텀시트 닫기
                            }
                            .padding(16.dp)
                    )
                }
            }
        }
    }
}
