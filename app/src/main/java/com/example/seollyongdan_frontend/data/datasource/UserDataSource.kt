package com.example.seollyongdan_frontend.data.datasource

import com.example.seollyongdan_frontend.data.dto.SeollyongdanBaseResponse
import com.example.seollyongdan_frontend.data.dto.response.ResponseUserDto

interface UserDataSource {

    suspend fun getUserInfo() : SeollyongdanBaseResponse<ResponseUserDto>

}