package com.example.seollyongdan_frontend.ui.component

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.seollyongdan_frontend.R
import com.example.seollyongdan_frontend.ui.theme.Gray200
import com.example.seollyongdan_frontend.ui.theme.Gray300
import com.example.seollyongdan_frontend.ui.theme.Gray50
import com.example.seollyongdan_frontend.ui.theme.White
import com.example.seollyongdan_frontend.ui.theme.h6Regular

@Composable
fun SearchTextField(
    value: String,
    onValueChange: (String) -> Unit,
    onSearchClick : () -> Unit,
    textAlign: TextAlign = TextAlign.Start
) {
    TextField(
        value = value,
        onValueChange = onValueChange,
        modifier = Modifier.height(56.dp).fillMaxWidth(),
        shape = RoundedCornerShape(10.dp),
        placeholder = { Text("궁금한 내용 검색해보기") },
        colors = TextFieldDefaults.colors(
            focusedContainerColor = Gray50,
            unfocusedContainerColor = Gray50,
            focusedIndicatorColor = Color.Transparent,
            unfocusedIndicatorColor = Color.Transparent,
            focusedTextColor = Gray300,
            unfocusedTextColor = Gray300
        ),

        trailingIcon = {
            IconButton(
                modifier = Modifier.size(30.dp),
                onClick = {
                    if (value.isNotBlank()){
                        onSearchClick()
                    }
                }
            ) {
                Icon(
                    painter = painterResource(id = R.drawable.ic_com_search),
                    contentDescription = "전송"
                )
            }
        }
    )
}

@Preview(showBackground = true)
@Composable
fun SearchTextFieldPreview() {
    SearchTextField(
        value = "",
        onValueChange = {},
        onSearchClick = {}
    )
}