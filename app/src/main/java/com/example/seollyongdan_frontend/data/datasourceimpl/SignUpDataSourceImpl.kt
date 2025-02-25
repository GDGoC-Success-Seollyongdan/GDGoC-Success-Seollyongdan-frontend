package com.example.seollyongdan_frontend.data.datasourceimpl

import com.example.seollyongdan_frontend.data.datasource.SignUpDataSource
import com.example.seollyongdan_frontend.data.dto.SeollyongdanBaseResponse
import com.example.seollyongdan_frontend.data.dto.request.RequestSignUpDto
import com.example.seollyongdan_frontend.data.service.AuthApiService
import javax.inject.Inject

class SignUpDataSourceImpl @Inject constructor(
    private val authApiService: AuthApiService
) : SignUpDataSource {
    override suspend fun postSignUp(requestSignUpDto: RequestSignUpDto) : SeollyongdanBaseResponse<String>{
        return authApiService.postSignUp(requestSignUpDto)
    }

    override suspend fun getIdDuplication(username: String): SeollyongdanBaseResponse<String> {
        return authApiService.getIdDuplication(username)
    }

    override suspend fun getNicknameDuplication(nickname: String): SeollyongdanBaseResponse<String> {
        return authApiService.getNicknameDuplication(nickname)
    }
}