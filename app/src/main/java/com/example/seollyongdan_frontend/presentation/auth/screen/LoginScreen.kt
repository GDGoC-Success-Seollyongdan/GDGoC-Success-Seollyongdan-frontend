package com.example.seollyongdan_frontend.presentation.auth.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Text
import androidx.compose.material3.VerticalDivider
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.sellyongdan_frontend.util.toast
import com.example.seollyongdan_frontend.R
import com.example.seollyongdan_frontend.ui.component.AuthButton
import com.example.seollyongdan_frontend.ui.component.AuthTextField
import com.example.seollyongdan_frontend.presentation.auth.navigation.AuthNavigator
import com.example.seollyongdan_frontend.ui.theme.Gray100
import com.example.seollyongdan_frontend.ui.theme.Info400
import com.example.seollyongdan_frontend.ui.theme.SeollyongdanfrontendTheme
import com.example.seollyongdan_frontend.ui.theme.White
import com.example.seollyongdan_frontend.ui.theme.b1Regular
import com.example.seollyongdan_frontend.ui.theme.b3Regular
import com.example.seollyongdan_frontend.ui.theme.h1Bold
import com.example.seollyongdan_frontend.ui.theme.h3Bold
import com.google.accompanist.systemuicontroller.rememberSystemUiController

@Composable
fun LoginRoute(
    navigator: AuthNavigator
) {
    val systemUiController = rememberSystemUiController()
    val keyboardController = LocalSoftwareKeyboardController.current

    SideEffect {
        systemUiController.setStatusBarColor(
            color = Color.White
        )
    }

    LoginScreen(
        onMainClick = {
            keyboardController?.hide()
            navigator.navigateMain()
        },
        onSignUpClick = { navigator.navigateSignUp() }
    )
}

@Composable
fun LoginScreen(
    onMainClick: () -> Unit = {},
    onSignUpClick: () -> Unit = {}
) {

    Column(
        modifier = Modifier
            .background(White)
            .fillMaxSize()
            .padding(16.dp)
    ) {
        var id by remember { mutableStateOf("") }
        var password by remember { mutableStateOf("") }
        val context = LocalContext.current

        Spacer(modifier = Modifier.height(105.dp))

        Text("로그인", style = h1Bold)

        Spacer(modifier = Modifier.height(30.dp))

        Row {
            Text("반가워요", style = h3Bold)
            Spacer(modifier = Modifier.width(5.dp))

            Image(
                painter = painterResource(id = R.drawable.ic_login_smile),
                contentDescription = "smile",
                modifier = Modifier
                    .height(26.dp)
                    .width(26.dp)
            )

        }

        Text(text = buildAnnotatedString {
            withStyle(style = SpanStyle(color = Info400)){
                append("서울시 사랑방")
            }
            append("입니다")
        }, style = h3Bold)
        Spacer(modifier = Modifier.height(15.dp))
        Text("회원 서비스 사용을 위해 로그인 해주세요.", style = b1Regular)

        Spacer(modifier = Modifier.height(67.dp))

        AuthTextField(
            value = id,
            onValueChange = { id = it },
            placeholderText = "아이디 입력"
        )
        Spacer(modifier = Modifier.height(11.dp))
        AuthTextField(
            value = password,
            onValueChange = { password = it },
            placeholderText = "비밀번호 입력"
        )
        Spacer(modifier = Modifier.height(20.dp))
        AuthButton(value = "로그인") {
            if (id.isNotBlank() && password.isNotBlank()) {
                onMainClick()
            } else {
                context.toast("아직 입력되지 않은 필드가 존재합니다.")
            }
        }
        Spacer(modifier = Modifier.height(21.dp))


        Row(
            modifier = Modifier.align(Alignment.CenterHorizontally),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text("아이디 찾기", style = b3Regular)
            Spacer(Modifier.width(22.dp))
            LoginDivider()
            Spacer(Modifier.width(22.dp))

            Text("비밀번호 찾기", style = b3Regular)
            Spacer(Modifier.width(22.dp))
            LoginDivider()
            Spacer(Modifier.width(22.dp))

            Text(
                "회원가입",
                style = b3Regular,
                modifier = Modifier.clickable {
                    onSignUpClick()
                }
            )
        }
    }


}

@Composable
fun LoginDivider() {
    VerticalDivider(
        modifier = Modifier
            .height(14.dp)
            .width(1.dp),
        color = Gray100
    )
}

@Preview
@Composable
fun LoginScreenPreview() {
    SeollyongdanfrontendTheme {
        LoginScreen(
            onMainClick = {},
            onSignUpClick = {}
        )
    }
}