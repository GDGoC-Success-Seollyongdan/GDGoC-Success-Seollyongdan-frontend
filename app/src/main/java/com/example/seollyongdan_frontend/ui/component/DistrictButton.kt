package com.example.seollyongdan_frontend.ui.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.seollyongdan_frontend.ui.theme.Primary900
import com.example.seollyongdan_frontend.ui.theme.h4Regular

@Composable
fun DistrictButton(
    color: Color,
    district: String,
    onClick: () -> Unit
) {
    Button(
        onClick = onClick,
        modifier = Modifier
            .fillMaxWidth()
            .height(67.dp),
        colors = ButtonDefaults.buttonColors(containerColor = color),
        contentPadding = PaddingValues(vertical = 10.dp)
    ) {
        Text(
            text = district,
            style = h4Regular
        )
    }
}

@Preview
@Composable
fun DistrictButtonPreview() {
    DistrictButton(
        color = Primary900,
        district = "성북구",
        onClick = {}
    )
}