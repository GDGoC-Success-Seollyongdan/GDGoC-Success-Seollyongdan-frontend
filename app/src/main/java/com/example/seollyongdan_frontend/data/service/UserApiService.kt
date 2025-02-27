package com.example.seollyongdan_frontend.data.service

import com.example.seollyongdan_frontend.data.dto.SeollyongdanBaseResponse
import com.example.seollyongdan_frontend.data.dto.response.ResponseUserDto
import com.example.seollyongdan_frontend.data.service.ApiKeyStorage.API
import com.example.seollyongdan_frontend.data.service.ApiKeyStorage.INFO
import com.example.seollyongdan_frontend.data.service.ApiKeyStorage.USERS
import retrofit2.http.GET

interface UserApiService {


    @GET("$API/$USERS/$INFO")
    suspend fun getUserInfo() : SeollyongdanBaseResponse<ResponseUserDto>
}