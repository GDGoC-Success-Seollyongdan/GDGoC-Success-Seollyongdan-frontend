package com.example.seollyongdan_frontend.data.datasourceimpl

import com.example.seollyongdan_frontend.data.datasource.UserDataSource
import com.example.seollyongdan_frontend.data.dto.SeollyongdanBaseResponse
import com.example.seollyongdan_frontend.data.dto.response.ResponseUserDto
import com.example.seollyongdan_frontend.data.service.UserApiService
import javax.inject.Inject

class UserDataSourceImpl @Inject constructor(
    private val userApiService: UserApiService
) : UserDataSource {

    override suspend fun getUserInfo(): SeollyongdanBaseResponse<ResponseUserDto> {
        return userApiService.getUserInfo()
    }
}