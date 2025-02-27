package com.example.seollyongdan_frontend.presentation.home.screen

import androidx.lifecycle.ViewModel
import com.example.seollyongdan_frontend.presentation.main.screen.UserEntity
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


}

//바텀 시트에서 보여줄 ui 결정
//사용자가 버튼을 클릭하면 해당 ui로 변경하는 역할!