package com.example.seollyongdan_frontend.data.service

import com.example.seollyongdan_frontend.data.dto.SeollyongdanBaseResponse
import com.example.seollyongdan_frontend.data.dto.request.RequestSearchFilterDto
import com.example.seollyongdan_frontend.data.dto.response.ResponseSearchFilterDto
import com.example.seollyongdan_frontend.data.service.ApiKeyStorage.API
import com.example.seollyongdan_frontend.data.service.ApiKeyStorage.PREFERENCE
import com.example.seollyongdan_frontend.data.service.ApiKeyStorage.USERS
import retrofit2.http.Body
import retrofit2.http.POST

interface SearchApiService {

    @POST("/$API/$USERS/$PREFERENCE")
    suspend fun postSearchFilter(
        @Body requestSearchFilterDto: RequestSearchFilterDto
    ): SeollyongdanBaseResponse<ResponseSearchFilterDto>
}