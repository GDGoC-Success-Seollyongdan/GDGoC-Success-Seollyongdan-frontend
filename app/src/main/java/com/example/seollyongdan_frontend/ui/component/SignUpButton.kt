package com.example.seollyongdan_frontend.ui.component

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.seollyongdan_frontend.ui.theme.Gray50
import com.example.seollyongdan_frontend.ui.theme.Gray900
import com.example.seollyongdan_frontend.ui.theme.Info400
import com.example.seollyongdan_frontend.ui.theme.White
import com.example.seollyongdan_frontend.ui.theme.h4Semi

@Composable
fun SignUpButton(
    value: String = "가입 완료",
    onClick: () -> Unit,
    enabled: Boolean = false
) {
    Button(
        modifier = Modifier
            .fillMaxWidth()
            .height(67.dp),
        shape = RoundedCornerShape(10.dp),
        onClick = onClick,
        colors = ButtonDefaults.buttonColors(
            containerColor = if (enabled) Info400 else Gray900,
            contentColor = Gray50
        ),
        contentPadding = PaddingValues(vertical = 10.dp),
        enabled = enabled

        ){
        Text(
            text = value,
            style = h4Semi,
        )

    }

}

@Preview
@Composable
fun SignUpButtonPreview(){
    SignUpButton(
        onClick = {},
        enabled = true
    )
}