package com.example.seollyongdan_frontend.domain.repository

import com.example.seollyongdan_frontend.data.dto.request.RequestLoginDto
import com.example.seollyongdan_frontend.data.dto.request.RequestSignUpDto
import com.example.seollyongdan_frontend.data.dto.response.ResponseLoginDto
import com.example.seollyongdan_frontend.data.dto.response.ResponseSignUpDto

interface AuthRepository{
    suspend fun postSignUp(requestSignUpDto : RequestSignUpDto) : Result<ResponseSignUpDto>

    suspend fun getIdDuplication(username : String) : Result<ResponseSignUpDto>

    suspend fun getNicknameDuplication(nickname : String) : Result<ResponseSignUpDto>

    suspend fun getLogin(requestLoginDto: RequestLoginDto) : Result<ResponseLoginDto>
}