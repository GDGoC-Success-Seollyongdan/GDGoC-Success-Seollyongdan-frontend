package com.example.seollyongdan_frontend.presentation.auth.screen

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SignUpDuplicationViewModel @Inject constructor(): ViewModel() {

    private val _idDuplicationState = mutableStateOf<Boolean?>(null)
    val idDuplicationState : State<Boolean?> = _idDuplicationState

    private val _nicknameDuplicationState = mutableStateOf<Boolean?>(null)
    val nicknameDuplicationState : State<Boolean?> = _nicknameDuplicationState

    fun checkIdDuplication(input : String){ //연동 전 임시 로직
        viewModelScope.launch {
            _idDuplicationState.value = (input.length %2 == 0) //일단 짝수면 중복, 홀수면 중복 아닌 걸로 판단
        }
    }

    fun checkNicknameDuplication(input : String){ //연동 전 임시 로직
        viewModelScope.launch {
            _nicknameDuplicationState.value = (input.length %2 == 0) //일단 짝수면 중복, 홀수면 중복 아닌 걸로 판단
        }
    }
}