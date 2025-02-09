package com.example.seollyongdan_frontend.ui.component

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.seollyongdan_frontend.ui.theme.Gray200
import com.example.seollyongdan_frontend.ui.theme.White
import com.example.seollyongdan_frontend.ui.theme.h6Regular

@Composable
fun AuthTextField(
    modifier: Modifier = Modifier,
    value: String,
    onValueChange: (String) -> Unit,
    placeholderText: String,
    textAlign: TextAlign = TextAlign.Start
) {
    OutlinedTextField(
        modifier = modifier
            .fillMaxWidth(),
        value = value,
        onValueChange = onValueChange,
        placeholder = {
            Text(
                modifier = Modifier.fillMaxWidth(),
                text = placeholderText,
                style = h6Regular,
                color = Gray200,
                textAlign = textAlign
            )
        },
        textStyle = h6Regular.copy(textAlign = textAlign),
        shape = RoundedCornerShape(5.dp),
        colors = OutlinedTextFieldDefaults.colors(
            focusedContainerColor = White,
            unfocusedContainerColor = Color.Transparent,
            focusedBorderColor = Gray200,
            unfocusedBorderColor = Gray200

        )
    )
}

@Preview(showBackground = true)
@Composable
fun AuthTextFieldPreview() {
    AuthTextField(
        value = "",
        onValueChange = {},
        placeholderText = "아이디 입력",
    )
}