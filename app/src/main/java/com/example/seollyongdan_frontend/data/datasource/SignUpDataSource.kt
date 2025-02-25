package com.example.seollyongdan_frontend.data.datasource

import com.example.seollyongdan_frontend.data.dto.SeollyongdanBaseResponse
import com.example.seollyongdan_frontend.data.dto.request.RequestSignUpDto

interface SignUpDataSource{
    suspend fun postSignUp(requestSignUpDto: RequestSignUpDto) : SeollyongdanBaseResponse<String>

    suspend fun getIdDuplication(username : String) : SeollyongdanBaseResponse<String>

    suspend fun getNicknameDuplication(nickname : String) : SeollyongdanBaseResponse<String>
}