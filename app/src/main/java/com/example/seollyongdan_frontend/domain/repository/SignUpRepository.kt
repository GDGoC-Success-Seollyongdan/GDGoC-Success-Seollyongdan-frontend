package com.example.seollyongdan_frontend.domain.repository

import com.example.seollyongdan_frontend.data.dto.request.RequestSignUpDto
import com.example.seollyongdan_frontend.data.dto.response.ResponseSignUpDto

interface SignUpRepository{
    suspend fun postSignUp(requestSignUpDto : RequestSignUpDto) : Result<ResponseSignUpDto>

    suspend fun getIdDuplication(username : String) : Result<ResponseSignUpDto>

    suspend fun getNicknameDuplication(nickname : String) : Result<ResponseSignUpDto>
}