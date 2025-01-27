package com.example.seollyongdan_frontend.data.service

import com.example.seollyongdan_frontend.data.dto.ExampleBaseResponse
import com.example.seollyongdan_frontend.data.dto.response.ResponseGetExampleDto
import com.example.seollyongdan_frontend.data.service.ApiKeyStorage.API
import com.example.seollyongdan_frontend.data.service.ApiKeyStorage.USERS
import retrofit2.http.GET
import retrofit2.http.Query

interface ExampleApiService {
    @GET("/$API/$USERS")
    suspend fun getUsers(
        @Query("page") page: Int
    ): ExampleBaseResponse<List<ResponseGetExampleDto>>
}