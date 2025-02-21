package com.example.seollyongdan_frontend.ui.component

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.seollyongdan_frontend.ui.theme.Success400
import com.example.seollyongdan_frontend.ui.theme.Success900
import com.example.seollyongdan_frontend.ui.theme.b3Bold

@Composable
fun UserProfile(
    district : String
){
    Box(
        modifier = Modifier
            .size(49.dp)
            .clip(RoundedCornerShape(100.dp))
            .background(Success400)
            .border(3.dp, color = Success900  ,RoundedCornerShape(100.dp)),
        contentAlignment = Alignment.Center
    ){
        Text(district,style = b3Bold)
    }

}

@Preview
@Composable
fun UserProfilePreview(){
    UserProfile("성북구")
}