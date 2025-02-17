package com.example.seollyongdan_frontend.ui.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.AccountCircle
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.seollyongdan_frontend.presentation.home.screen.StaticRatingBar
import com.example.seollyongdan_frontend.ui.theme.Success400
import com.example.seollyongdan_frontend.ui.theme.Success900

@Composable
fun UserReview(
    starRate: Float,
    message: String
) {
    Box(
        modifier = Modifier
            .wrapContentHeight()
            .fillMaxWidth()
            .background(
                color = Success400,
                shape = RoundedCornerShape(20)
            )
            .padding(16.dp)
    ) {
        Row {
            Icon(
                imageVector = Icons.Rounded.AccountCircle,
                contentDescription = "회원 아이콘",
                tint = Success900,
                modifier = Modifier.size(55.dp)
            )
            Spacer(modifier = Modifier.width(20.dp))
            Column {
                StaticRatingBar(starRate)
                Text(message)
            }
        }
    }
}

@Preview
@Composable
fun UserReviewPreview() {
    UserReview(starRate = 3.4f, message = "치안이 좋아요")
}