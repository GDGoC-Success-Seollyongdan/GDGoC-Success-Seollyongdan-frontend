package com.example.seollyongdan_frontend.presentation.community.screen

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.seollyongdan_frontend.data.dto.request.RequestCommunityNewPostDto
import com.example.seollyongdan_frontend.domain.repository.CommunityRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CommunityWriteViewModel @Inject constructor(
    private val repository: CommunityRepository
) : ViewModel() {

    private val _isPostSuccess = mutableStateOf<Boolean?>(null) //회원가입 성공 여부 screen에게 알려줌
    val isPostSuccess: State<Boolean?> = _isPostSuccess


    fun postNewPost(nickName: String, postDistrict: String, title: String, content: String) {

        val requestCommunityNewPostDto =
            RequestCommunityNewPostDto(nickName, postDistrict, title, content)

        viewModelScope.launch {
            val result = repository.postNewPost(requestCommunityNewPostDto)
            result.onSuccess { response ->
                if (response == true) {
                    _isPostSuccess.value = true
                }

            }

        }
    }
}