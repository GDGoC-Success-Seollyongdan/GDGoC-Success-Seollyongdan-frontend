package com.example.seollyongdan_frontend.data.service

import com.example.seollyongdan_frontend.data.dto.response.RegionResponseDto
import com.example.seollyongdan_frontend.data.service.ApiKeyStorage.REGION
import retrofit2.http.GET
import retrofit2.http.Query

interface RegionApiService {
    @GET("$REGION")
    suspend fun getRegions(
        @Query("serviceKey") serviceKey: String,
        @Query("page") page: Int,
        @Query("perPage") perPage: Int,
        @Query("returnType") returnType: String = "JSON"
    ): RegionResponseDto
}
