package com.example.seollyongdan_frontend.presentation.auth.screen

import android.content.SharedPreferences
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.seollyongdan_frontend.data.dto.request.RequestLoginDto
import com.example.seollyongdan_frontend.domain.repository.AuthRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor(
    private val repository: AuthRepository,
    private val preferences: SharedPreferences
) : ViewModel() {

    private val _loginState = mutableStateOf<Boolean?>(null) //로그인 성공 여부 screen에게 알려줌
    val loginState: State<Boolean?> = _loginState

    private val _loginError = mutableStateOf<String?>(null)
    val loginError : State<String?> = _loginError


    fun getLogin(id: String, password: String){
        val requestLoginDto = RequestLoginDto(id, password)

        viewModelScope.launch {
            val result = repository.getLogin(requestLoginDto)

            result.onSuccess { response ->
                val token = response.token
                if (token != null){
                    _loginState.value = true
                    saveToken(token)
                } else{
                    _loginState.value = false
                    _loginError.value = "token is null"
                }
            }.onFailure { exception ->
                _loginState.value = false
                _loginError.value = exception.message
            }
        }
    }

    private fun saveToken(token : String){
        preferences.edit()
            .putString("USER_TOKEN", token)
            .apply()

    }

    fun resetLoginState() {
        _loginState.value = null
        _loginError.value = null
    }

}
