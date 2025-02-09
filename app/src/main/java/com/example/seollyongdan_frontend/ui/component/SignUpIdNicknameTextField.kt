package com.example.seollyongdan_frontend.ui.component

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
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
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.seollyongdan_frontend.presentation.auth.screen.SignUpDuplicationViewModel
import com.example.seollyongdan_frontend.ui.theme.Gray200
import com.example.seollyongdan_frontend.ui.theme.Gray50
import com.example.seollyongdan_frontend.ui.theme.b3Regular
import com.example.seollyongdan_frontend.ui.theme.b4Regular
import com.example.seollyongdan_frontend.ui.theme.h6Regular
import com.example.seollyongdan_frontend.ui.theme.h7Semi

@Composable
fun SignUpIdNicknameTextField(
    modifier: Modifier = Modifier,
    type: String,
    value: String,
    onValueChange: (String) -> Unit,
    title: String,
    textAlign: TextAlign = TextAlign.Start,
    noDuplicationText: String,
    duplicationText: String,
    onCheckDuplication: (String) -> Unit,
    duplicationState: Boolean?,
    warningMessage: String
) {
    val isValid = remember(value) {
        when (type) {
            "id" -> value.matches(Regex("[a-z0-9]{4,12}$")) // 아이디 조건
            "nickname" ->value.matches(Regex("[a-zA-Z0-9]{2,}$")) // 닉네임 최소 2자
            else -> false
        }
    }


    Column {
        Text(title, style = h7Semi)

        Spacer(modifier = Modifier.height(8.dp))

        Row {
            OutlinedTextField(
                modifier = modifier
                    .weight(1f)
                    .height(50.dp),
                value = value,
                onValueChange = onValueChange,
                placeholder = {
                    Text(
                        modifier = Modifier.fillMaxWidth(),
                        text = title,
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

            Spacer(modifier = Modifier.width(14.dp))

            SignUpDuplicationCheckButton(
                value = "중복확인",
                onClick = { onCheckDuplication(value) },
                enabled = isValid // 입력이 유효할 때만 클릭 가능
            )
        }

        Spacer(modifier = Modifier.height(11.dp))

        if (!isValid) {
            Text(warningMessage, style = b3Regular, color = Color.Red, modifier = Modifier.align(Alignment.CenterHorizontally))
        } else {
            duplicationState?.let { isDuplicated ->
                val resultText = if (isDuplicated) duplicationText else noDuplicationText
                val resultColor = if (isDuplicated) Color.Red else Color.Green
                Text(resultText, style = b4Regular, color = resultColor,
                    modifier = Modifier.align(Alignment.CenterHorizontally))
            }
        }
    }
}


@Preview
@Composable
fun SignUpIdNicknameTextFieldPreview(){
    var id by remember { mutableStateOf("") }
    val signUpDuplicationViewModel : SignUpDuplicationViewModel = hiltViewModel()

    SignUpIdNicknameTextField(
        type = "id",
        value = id,
        onValueChange = {id = it},
        title = "아이디 입력",
        noDuplicationText = "사용 가능한 아이디입니다.",
        duplicationText = "이미 사용 중인 아이디입니다.",
        onCheckDuplication = {input -> signUpDuplicationViewModel.checkIdDuplication(input) },
        duplicationState = signUpDuplicationViewModel.idDuplicationState.value,
        warningMessage = ""
    )
}