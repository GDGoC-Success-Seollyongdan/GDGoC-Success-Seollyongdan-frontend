package com.example.seollyongdan_frontend.ui.component

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.seollyongdan_frontend.R
import com.example.seollyongdan_frontend.ui.theme.Info400
import com.example.seollyongdan_frontend.ui.theme.White
import com.example.seollyongdan_frontend.ui.theme.h5Semi

@Composable
fun CommunityFloatingButton(
    onWriteClick: () -> Unit,
    onReviewClick: () -> Unit
) {

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        FloatingButton("review", onReviewClick)


        FloatingButton("write", onWriteClick)
    }

}

@Composable
fun FloatingButton(
    type: String,
    onClick: () -> Unit,
) {
    val bgColor =
        if (type == "write") {
            Info400
        } else {
            White
        }

    val textColor =
        if (type == "write") {
            White
        } else {
            Info400
        }

    val tintColor =
        if (type == "write") {
            White
        } else {
            Info400
        }

    val text =
        if (type == "write") {
            "글쓰기"
        } else {
            "동네 리뷰"
        }

    val iconResource =
        if (type == "write") {
            R.drawable.ic_com_write
        } else {
            R.drawable.ic_com_review
        }

    val buttonWidth =
        if (type == "write") {
            135.dp
        } else {
            160.dp
        }

    Button(
        shape = RoundedCornerShape(30.dp),
        modifier = Modifier
            .width(buttonWidth)
            .height(45.dp)
            .border(1.dp, Info400, shape = RoundedCornerShape(30.dp)),
        onClick = onClick,
        colors = ButtonDefaults.buttonColors(bgColor)
    ) {
        Row {
            Icon(
                painter = painterResource(id = iconResource),
                contentDescription = "아이콘",
                modifier = Modifier.size(24.dp),
                tint = tintColor
            )
            Spacer(modifier = Modifier.width(10.dp))
            Text(text, style = h5Semi, color = textColor)

        }
    }

}

@Preview
@Composable
fun CommunityFloatingButtonPreview() {
    CommunityFloatingButton(
        onWriteClick = {},
        onReviewClick = {}
    )
}