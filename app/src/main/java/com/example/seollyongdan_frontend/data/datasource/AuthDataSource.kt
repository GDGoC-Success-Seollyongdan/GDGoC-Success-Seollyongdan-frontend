package com.example.seollyongdan_frontend.data.datasource

import com.example.seollyongdan_frontend.data.dto.SeollyongdanBaseResponse
import com.example.seollyongdan_frontend.data.dto.request.RequestLoginDto
import com.example.seollyongdan_frontend.data.dto.request.RequestSignUpDto
import com.example.seollyongdan_frontend.data.dto.response.ResponseLoginDto

interface AuthDataSource{
    suspend fun postSignUp(requestSignUpDto: RequestSignUpDto) : SeollyongdanBaseResponse<String>

    suspend fun getIdDuplication(username : String) : SeollyongdanBaseResponse<String>

    suspend fun getNicknameDuplication(nickname : String) : SeollyongdanBaseResponse<String>

    suspend fun getLogin(requestLoginDto: RequestLoginDto) : SeollyongdanBaseResponse<ResponseLoginDto>
}