package com.example.seollyongdan_frontend.presentation.auth.screen

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.seollyongdan_frontend.data.dto.request.RequestSignUpDto
import com.example.seollyongdan_frontend.domain.repository.SignUpRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SignUpViewModel @Inject constructor(
    private val repository: SignUpRepository
) : ViewModel() {

    private val _toastMessage = MutableSharedFlow<String>()
    val toastMessage = _toastMessage.asSharedFlow()

    private val _signUpState = mutableStateOf<Boolean?>(null) //회원가입 성공 여부 screen에게 알려줌
    val signUpState: State<Boolean?> = _signUpState

    private val _idDuplicationState = mutableStateOf<Boolean?>(null) //id 중복 여부 screen에게 알려줌
    val idDuplicationState: State<Boolean?> = _idDuplicationState

    private val _nicknameDuplicationState = mutableStateOf<Boolean?>(null) //닉네임 중복 여부 screen에게 알려줌
    val nicknameDuplicationState: State<Boolean?> = _nicknameDuplicationState


    fun postSignUp(id: String, password: String, nickName: String, district: String) {
        val requestSignUpDto = RequestSignUpDto(id, password, nickName, district)

        viewModelScope.launch {
            val result = repository.postSignUp(requestSignUpDto)
            result.onSuccess { response ->
                if (response.success) {
                    _signUpState.value = true
                    _toastMessage.emit("회원가입이 완료되었습니다.")
                } else {
                    _signUpState.value = false
                    _toastMessage.emit(response.error ?: "회원가입에 실패했습니다.")
                }
            }.onFailure {
                _toastMessage.emit("네트워크 오류가 발생했습니다.")
            }
        }
    }

    fun getNicknameDuplication(nickname: String) {
        viewModelScope.launch {
            val result = repository.getNicknameDuplication(nickname)
            result.onSuccess { response ->
                if (response.success) {
                    _nicknameDuplicationState.value = false //false = 중복 아님
                } else {
                    _nicknameDuplicationState.value = true
                }
            }.onFailure {
                _toastMessage.emit("네트워크 오류가 발생했습니다.")
            }

        }
    }

    fun getIdDuplication(username: String) {
        viewModelScope.launch {
            val result = repository.getIdDuplication(username)
            result.onSuccess { response ->
                if (response.success) {
                    _idDuplicationState.value = false //false = 중복 아님
                } else {
                    _idDuplicationState.value = true
                }
            }.onFailure {
                _toastMessage.emit("네트워크 오류가 발생했습니다.")
            }

        }
    }
}


