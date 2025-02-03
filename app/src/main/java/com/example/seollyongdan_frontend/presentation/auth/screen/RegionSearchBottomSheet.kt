package com.example.seollyongdan_frontend.presentation.auth.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.seollyongdan_frontend.ui.theme.Gray200
import com.example.seollyongdan_frontend.ui.theme.Gray50
import com.example.seollyongdan_frontend.ui.theme.Gray700
import com.example.seollyongdan_frontend.ui.theme.h6Regular
import com.example.seollyongdan_frontend.ui.theme.h7Regular
import com.example.seollyongdan_frontend.ui.theme.h7Semi

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun RegionSearchBottomSheet(
    onDismiss: () -> Unit,
    onItemSelected: (String) -> Unit,
    regions: List<String>
) {
    ModalBottomSheet(onDismissRequest = onDismiss) {
        Text("바텀 시트 표시됨")
    }
    /*var searchQuery by remember { mutableStateOf("") }

    val filteredRegions = regions.filter { it.contains(searchQuery, ignoreCase = true) }

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

            OutlinedTextField(
                modifier = Modifier
                    .height(50.dp)
                    .fillMaxWidth(),
                value = searchQuery,
                onValueChange = {searchQuery = it},
                placeholder = {
                    Text(
                        modifier = Modifier.fillMaxWidth(),
                        text = "시/구/동을 검색하세요",
                        style = h7Semi,
                        color = Gray200,
                        textAlign = TextAlign.Start
                    )
                },
                textStyle = h6Regular.copy(textAlign = TextAlign.Start),
                shape = RoundedCornerShape(10.dp),
                colors = OutlinedTextFieldDefaults.colors(
                    focusedContainerColor = Gray50,
                    unfocusedContainerColor = Gray50,
                    focusedBorderColor = Gray50,
                    unfocusedBorderColor = Gray50
                )
            )

            Spacer(modifier = Modifier.height(15.dp))

            LazyColumn {
                items(filteredRegions) { region ->
                    Text(
                        text = region,
                        style = h7Regular,
                        color = Gray700,
                        modifier = Modifier
                            .fillMaxWidth()
                            .clickable {
                                onItemSelected(region)
                                onDismiss()
                            }
                            .padding(16.dp)
                    )
                }
            }
        }
    }*/
}


@Preview
@Composable
fun RegionSearchBottomSheetPreview() {

    val regions = listOf(
        "강원도 삼척시 노곡면",
        "강원도 삼척시 도곡면",
        "강원도 삼척시 로곡면",
        "강원도 삼척시 모곡면",
        "강원도 삼척시 보곡면"
    )
    Column(modifier = Modifier
        .background(Color.White)
        .padding(16.dp)) {

        OutlinedTextField(
            modifier = Modifier
                .height(50.dp)
                .fillMaxWidth(),
            value = "",
            onValueChange = {},
            placeholder = {
                Text(
                    modifier = Modifier.fillMaxWidth(),
                    text = "시/구/동을 검색하세요",
                    style = h7Semi,
                    color = Gray200,
                    textAlign = TextAlign.Start
                )
            },
            textStyle = h6Regular.copy(textAlign = TextAlign.Start),
            shape = RoundedCornerShape(10.dp),
            colors = OutlinedTextFieldDefaults.colors(
                focusedContainerColor = Gray50,
                unfocusedContainerColor = Gray50,
                focusedBorderColor = Gray50,
                unfocusedBorderColor = Gray50
            )
        )

        Spacer(modifier = Modifier.height(15.dp))

        LazyColumn {
            items(regions) { region ->
                Text(
                    text = region,
                    style = h7Regular,
                    color = Gray700,
                    modifier = Modifier
                        .fillMaxWidth()
                        .clickable {

                        }
                        .padding(16.dp)
                )
            }
        }
    }
}