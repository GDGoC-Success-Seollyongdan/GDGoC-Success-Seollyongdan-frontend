package com.example.seollyongdan_frontend.data.datasourceimpl

import com.example.seollyongdan_frontend.data.datasource.AuthDataSource
import com.example.seollyongdan_frontend.data.dto.SeollyongdanBaseResponse
import com.example.seollyongdan_frontend.data.dto.request.RequestLoginDto
import com.example.seollyongdan_frontend.data.dto.request.RequestSignUpDto
import com.example.seollyongdan_frontend.data.dto.response.ResponseLoginDto
import com.example.seollyongdan_frontend.data.service.AuthApiService
import javax.inject.Inject

class AuthDataSourceImpl @Inject constructor(
    private val authApiService: AuthApiService
) : AuthDataSource {
    override suspend fun postSignUp(requestSignUpDto: RequestSignUpDto) : SeollyongdanBaseResponse<String>{
        return authApiService.postSignUp(requestSignUpDto)
    }

    override suspend fun getIdDuplication(username: String): SeollyongdanBaseResponse<String> {
        return authApiService.getIdDuplication(username)
    }

    override suspend fun getNicknameDuplication(nickname: String): SeollyongdanBaseResponse<String> {
        return authApiService.getNicknameDuplication(nickname)
    }

    override suspend fun getLogin(requestLoginDto: RequestLoginDto): SeollyongdanBaseResponse<ResponseLoginDto> {
        return authApiService.getLogin(requestLoginDto)
    }
}