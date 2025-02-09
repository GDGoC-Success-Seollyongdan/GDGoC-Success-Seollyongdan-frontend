package com.example.seollyongdan_frontend.ui.component

import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.seollyongdan_frontend.ui.theme.Gray100
import com.example.seollyongdan_frontend.ui.theme.Gray300
import com.example.seollyongdan_frontend.ui.theme.Gray50
import com.example.seollyongdan_frontend.ui.theme.Info300
import com.example.seollyongdan_frontend.ui.theme.h7Semi

@Composable
fun SignUpDuplicationCheckButton(
    value : String,
    onClick : () -> Unit,
    enabled : Boolean
){
    Button(
        modifier = Modifier
            .width(108.dp)
            .height(50.dp),
        shape = RoundedCornerShape(10.dp),
        onClick = onClick,
        colors = ButtonDefaults.buttonColors(
            containerColor = if (enabled) Info300 else Gray100, // 조건 충족 시 Info400, 아니면 Gray50
            contentColor = if (enabled) Gray50 else Gray300
        ),
        enabled = enabled

    ){
        Text(
            text = value,
            style = h7Semi,
        )

    }

}

@Preview
@Composable
fun DuplicationCheckButtonPreview(){
    SignUpDuplicationCheckButton(
        value = "중복확인",
        onClick = {},
        enabled = true
    )
}