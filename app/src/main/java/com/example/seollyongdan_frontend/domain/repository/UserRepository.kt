package com.example.seollyongdan_frontend.domain.repository

import com.example.seollyongdan_frontend.data.dto.SeollyongdanBaseResponse
import com.example.seollyongdan_frontend.data.dto.response.ResponseUserDto

interface UserRepository {

    suspend fun getUserInfo() : Result<ResponseUserDto>


}