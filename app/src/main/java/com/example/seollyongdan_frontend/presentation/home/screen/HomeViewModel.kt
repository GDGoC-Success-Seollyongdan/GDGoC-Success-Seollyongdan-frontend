package com.example.seollyongdan_frontend.presentation.home.screen

import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor() : ViewModel() {
    private val _bottomSheetScreen = MutableStateFlow(BottomSheetScreen.HOME)
    val bottomSheetScreen: StateFlow<BottomSheetScreen> = _bottomSheetScreen

    fun setBottomSheetScreen(screen: BottomSheetScreen) {
        _bottomSheetScreen.value = screen
    }

    val userData = UserEntity( //로그인 성공 시에 api로 받아오도록 수정 필요
            district = "용산구 청파로1가",
            isResident = true,
            nickname = "김눈송"
        )

}

//바텀 시트에서 보여줄 ui 결정
//사용자가 버튼을 클릭하면 해당 ui로 변경하는 역할!