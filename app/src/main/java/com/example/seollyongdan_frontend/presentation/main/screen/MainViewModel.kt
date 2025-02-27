package com.example.seollyongdan_frontend.presentation.main.screen

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.seollyongdan_frontend.data.dto.response.ResponseUserDto
import com.example.seollyongdan_frontend.domain.repository.UserRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class MainViewModel @Inject constructor(
    private val repository: UserRepository
) : ViewModel() {

    private val _userDto = MutableStateFlow<ResponseUserDto?>(null)
    val userDto: StateFlow<ResponseUserDto?> = _userDto

    fun getUserInfo() {
        viewModelScope.launch {
            val result = repository.getUserInfo()
            result.onSuccess { response ->
                _userDto.value = response
            }.onFailure {
                // 오류 처리 로직
            }
        }
    }
}