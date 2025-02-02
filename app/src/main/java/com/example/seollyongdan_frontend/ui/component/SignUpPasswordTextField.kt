package com.example.seollyongdan_frontend.ui.component


import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.seollyongdan_frontend.ui.theme.Gray200
import com.example.seollyongdan_frontend.ui.theme.Gray50
import com.example.seollyongdan_frontend.ui.theme.b3Regular
import com.example.seollyongdan_frontend.ui.theme.h6Regular
import com.example.seollyongdan_frontend.ui.theme.h7Semi

@Composable
fun SignUpPasswordTextField(
    modifier: Modifier = Modifier,
    firstValue: String,
    onFirstValueChange: (String) -> Unit,
    secondValue: String,
    onSecondValueChange: (String) -> Unit,
    showValidWarning: Boolean,
    showMatchWarning : Boolean,
    textAlign: TextAlign = TextAlign.Start,
    ) {

    val title = "비밀번호"
    val firstPlaceholderText = "비밀번호"
    val secondPlaceholderText = "비밀번호 확인"
    val validWarningMessage = "영문 대소문자, 숫자, 특수문자를 조합하여 6~20자로 입력해주세요"
    val matchWarningMessage = "두 비밀번호의 값이 일치하지 않습니다"

    Column {
        Text(title, style = h7Semi)

        Spacer(modifier = Modifier.height(8.dp))

        OutlinedTextField(
            modifier = modifier
                .height(50.dp),
            value = firstValue,
            onValueChange = onFirstValueChange,
            placeholder = {
                Text(
                    modifier = Modifier.fillMaxWidth(),
                    text = firstPlaceholderText,
                    style = h7Semi,
                    color = Gray200,
                    textAlign = textAlign
                )
            },
            textStyle = h6Regular.copy(textAlign = textAlign),
            shape = RoundedCornerShape(10.dp),
            colors = OutlinedTextFieldDefaults.colors(
                focusedContainerColor = Gray50,
                unfocusedContainerColor = Gray50,
                focusedBorderColor = Gray50,
                unfocusedBorderColor = Gray50
            )
        )

        Spacer(modifier = Modifier.height(8.dp))

        OutlinedTextField(
            modifier = modifier
                .height(50.dp),
            value = secondValue,
            onValueChange = onSecondValueChange,
            placeholder = {
                Text(
                    modifier = Modifier.fillMaxWidth(),
                    text = secondPlaceholderText,
                    style = h7Semi,
                    color = Gray200,
                    textAlign = textAlign
                )
            },
            textStyle = h6Regular.copy(textAlign = textAlign),
            shape = RoundedCornerShape(10.dp),
            colors = OutlinedTextFieldDefaults.colors(
                focusedContainerColor = Gray50,
                unfocusedContainerColor = Gray50,
                focusedBorderColor = Gray50,
                unfocusedBorderColor = Gray50
            )
        )

        Spacer(modifier = Modifier.height(11.dp))

        if (showValidWarning == true && showMatchWarning == false) {
            Text(
                validWarningMessage,
                style = b3Regular,
                color = Color.Red,
                modifier = Modifier.align(Alignment.CenterHorizontally)
            )
        }
        else if (showValidWarning == false && showMatchWarning == true){
            Text(
                matchWarningMessage,
                style = b3Regular,
                color = Color.Red,
                modifier = Modifier.align(Alignment.CenterHorizontally)
            )
        }
        else if (showValidWarning == true && showMatchWarning == true){
            Text(
                validWarningMessage,
                style = b3Regular,
                color = Color.Red,
                modifier = Modifier.align(Alignment.CenterHorizontally)
            )

            Spacer(modifier = Modifier.height(11.dp))

            Text(
                matchWarningMessage,
                style = b3Regular,
                color = Color.Red,
                modifier = Modifier.align(Alignment.CenterHorizontally)
            )
        }
    }
}


@Preview
@Composable
fun SignUpPasswordTextFieldPreview() {
    var password by remember { mutableStateOf("") }
    var checkPassword by remember { mutableStateOf("") }

    SignUpPasswordTextField(
        firstValue = password,
        onFirstValueChange = { password = it },
        secondValue = checkPassword,
        onSecondValueChange = { checkPassword = it },
        showValidWarning = false,
        showMatchWarning = true
    )

}