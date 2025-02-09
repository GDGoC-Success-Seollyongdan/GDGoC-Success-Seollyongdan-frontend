package com.example.seollyongdan_frontend.presentation.auth.screen

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.Text
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.SideEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.sellyongdan_frontend.util.toast
import com.example.seollyongdan_frontend.R
import com.example.seollyongdan_frontend.presentation.auth.navigation.AuthNavigator
import com.example.seollyongdan_frontend.ui.component.SignUpButton
import com.example.seollyongdan_frontend.ui.component.SignUpIdNicknameTextField
import com.example.seollyongdan_frontend.ui.component.SignUpPasswordTextField
import com.example.seollyongdan_frontend.ui.theme.Gray200
import com.example.seollyongdan_frontend.ui.theme.Gray50
import com.example.seollyongdan_frontend.ui.theme.SeollyongdanfrontendTheme
import com.example.seollyongdan_frontend.ui.theme.White
import com.example.seollyongdan_frontend.ui.theme.b3Regular
import com.example.seollyongdan_frontend.ui.theme.h1Bold
import com.example.seollyongdan_frontend.ui.theme.h7Semi
import com.google.accompanist.systemuicontroller.rememberSystemUiController
import kotlinx.coroutines.launch

@Composable
fun SignUpRoute(
    navigator: AuthNavigator
) {
    val systemUiController = rememberSystemUiController()
    val signUpDuplicationViewModel: SignUpDuplicationViewModel = hiltViewModel()
    val regionViewModel: RegionViewModel = hiltViewModel()

    SideEffect {
        systemUiController.setStatusBarColor(
            color = Color.White
        )
    }

    SignUpScreen(
        onNextClick = {
            navigator.navigateLogin()
        },
        onBackClick = {
            navigator.navigateBack()
        },
        signUpDuplicationViewModel = signUpDuplicationViewModel,
        regionViewModel = regionViewModel
    )
}


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SignUpScreen(
    onNextClick: () -> Unit = {},
    onBackClick: () -> Unit = {},
    signUpDuplicationViewModel: SignUpDuplicationViewModel,
    regionViewModel: RegionViewModel
) {
    var id by remember { mutableStateOf("") }
    var nickname by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var checkPassword by remember { mutableStateOf("") }

    val bottomSheetState = rememberModalBottomSheetState()
    val coroutineScope = rememberCoroutineScope()
    var selectedRegion by remember { mutableStateOf("") }
    var isBottomSheetVisible by remember { mutableStateOf(false) }
    val regions by regionViewModel.regions.collectAsState()

    val textAlign: TextAlign = TextAlign.Start

    val formattedDistricts = remember(regions) {
        regions.mapNotNull { region ->
            listOf(region.city, region.district, region.town)
                .filterNotNull()
                .takeIf { it.isNotEmpty() }
                ?.joinToString(" ")
        }.distinct()
    }

    fun showBottomSheet() {
        coroutineScope.launch {
            bottomSheetState.show()
            bottomSheetState.expand()
        }
    }

    fun hideBottomSheet() {
        coroutineScope.launch { bottomSheetState.hide() }
    }


    val context = LocalContext.current

    // 각 필드의 유효성 검사 상태
    val isPasswordValid = remember(password) {
        password.matches(Regex("(?=.*[a-z])(?=.*[A-Z])(?=.*[0-9])(?=.*[!@#]).{6,20}$"))
    }
    val isPasswordMatch = remember(password, checkPassword) {
        password == checkPassword && password.isNotEmpty()
    }

    LaunchedEffect(Unit) {
        regionViewModel.fetchRegions(page = 1, perPage = 1800)
    }


    // 모든 조건이 충족되었는지 확인
    val isFormValid = remember(
        id,
        nickname,
        password,
        checkPassword,
        selectedRegion,
        signUpDuplicationViewModel.idDuplicationState.value,
        signUpDuplicationViewModel.nicknameDuplicationState.value,
        isPasswordValid,
        isPasswordMatch
    ) {
        selectedRegion.isNotEmpty() &&
                signUpDuplicationViewModel.idDuplicationState.value == false &&  // false는 중복되지 않음을 의미
                signUpDuplicationViewModel.nicknameDuplicationState.value == false &&
                isPasswordValid &&
                isPasswordMatch
    }


    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(White)
            .padding(top = 25.dp)
            .padding(horizontal = 16.dp)
    ) {
        IconButton(onClick = onBackClick, modifier = Modifier.width(11.dp)) {
            Icon(
                imageVector = ImageVector.vectorResource(id = R.drawable.ic_back),
                contentDescription = "이전으로 돌아가기"
            )
        }

        Spacer(modifier = Modifier.height(19.dp))

        Text("회원가입", style = h1Bold)

        Spacer(modifier = Modifier.height(35.dp))

        SignUpIdNicknameTextField(
            type = "id",
            value = id,
            onValueChange = { id = it },
            title = "아이디 입력",
            noDuplicationText = "사용 가능한 아이디입니다.",
            duplicationText = "이미 사용 중인 아이디입니다.",
            onCheckDuplication = { input -> signUpDuplicationViewModel.checkIdDuplication(input) },
            duplicationState = signUpDuplicationViewModel.idDuplicationState.value,
            warningMessage = "영문 소문자와 숫자만 사용하여, 4~12자의 아이디를 입력해주세요."
        )

        Spacer(modifier = Modifier.height(32.dp))

        SignUpPasswordTextField(
            firstValue = password,
            onFirstValueChange = { password = it },
            secondValue = checkPassword,
            onSecondValueChange = { checkPassword = it },
            showValidWarning = password.isNotEmpty() && !isPasswordValid,
            showMatchWarning = !isPasswordMatch
        )

        Spacer(modifier = Modifier.height(32.dp))

        SignUpIdNicknameTextField(
            type = "nickname",
            value = nickname,
            onValueChange = { nickname = it },
            title = "닉네임 입력",
            noDuplicationText = "사용 가능한 닉네임입니다.",
            duplicationText = "이미 사용 중인 닉네임입니다.",
            onCheckDuplication = { input ->
                signUpDuplicationViewModel.checkNicknameDuplication(
                    input
                )
            },
            duplicationState = signUpDuplicationViewModel.nicknameDuplicationState.value,
            warningMessage = "2글자 이상 작성해주세요."

        )

        Spacer(modifier = Modifier.height(32.dp))

        Column(
        ) {
            Text("내 동네 설정하기", style = h7Semi)

            Spacer(modifier = Modifier.height(8.dp))

            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(50.dp)
                    .clip(RoundedCornerShape(10.dp))
                    .background(Gray50)
                    .clickable {
                        Log.d("SignUpScreen", "내 동네 설정하기 클릭됨")
                        isBottomSheetVisible = true
                        showBottomSheet()
                    },
                contentAlignment = Alignment.CenterStart
            ) {

                Row(){
                    Spacer(modifier = Modifier.width(16.dp))

                    Text(
                        text = if (selectedRegion.isNotEmpty()) selectedRegion else "동명으로 검색 (ex. 청파동)",
                        style = h7Semi,
                        color = Gray200,
                        textAlign = textAlign
                    )

                }
            }
            Spacer(modifier = Modifier.height(11.dp))

            if (selectedRegion.isEmpty()) {
                Text(
                    "동네를 설정해주세요",
                    style = b3Regular,
                    color = Color.Red,
                    modifier = Modifier.align(Alignment.CenterHorizontally)
                )
            }

        }



        if (isBottomSheetVisible) {
            ModalBottomSheet(
                onDismissRequest = {
                    hideBottomSheet()
                    isBottomSheetVisible = false
                },
                sheetState = bottomSheetState
            ) {
                RegionSearchBottomSheet(
                    onDismiss = {
                        hideBottomSheet()
                        isBottomSheetVisible = false
                    },
                    onItemSelected = { address ->
                        selectedRegion = address
                        hideBottomSheet()
                        isBottomSheetVisible = false
                    },
                    regions = formattedDistricts, // 예제 데이터
                    sheetState = bottomSheetState
                )
            }
        }

        Spacer(modifier = Modifier.weight(1f))

        SignUpButton(
            value = "가입 완료",
            onClick = {
                if (isFormValid) {
                    onNextClick()
                } else {
                    context.toast("중복 검사 또는 조건을 충족하는지 확인해주세요.")
                }
            },
            enabled = isFormValid
        )
        Spacer(modifier = Modifier.height(19.dp))


    }
}



@Preview
@Composable
fun SignUpScreenPreview() {
    SeollyongdanfrontendTheme {
        //val signUpDuplicationViewModel: SignUpDuplicationViewModel = hiltViewModel()
        //val regionViewModel: RegionViewModel = hiltViewModel()

        SignUpScreen(
            onNextClick = {
            },
            onBackClick = {
            },
            signUpDuplicationViewModel = hiltViewModel(),
            regionViewModel = hiltViewModel()
        )
    }
}