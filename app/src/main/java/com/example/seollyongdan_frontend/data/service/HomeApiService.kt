package com.example.seollyongdan_frontend.data.service

import com.example.seollyongdan_frontend.data.dto.SeollyongdanBaseResponse
import com.example.seollyongdan_frontend.data.dto.response.ResponseHomeSafetyDto
import com.example.seollyongdan_frontend.data.dto.response.ResponseRealEstateDto
import com.example.seollyongdan_frontend.data.service.ApiKeyStorage.API
import com.example.seollyongdan_frontend.data.service.ApiKeyStorage.PROPERTIES
import com.example.seollyongdan_frontend.data.service.ApiKeyStorage.SAFETY
import com.example.seollyongdan_frontend.data.service.ApiKeyStorage.TOWN
import retrofit2.http.GET
import retrofit2.http.Path

interface HomeApiService {

    @GET("/$API/$TOWN/{town-id}/$SAFETY")
    suspend fun getTownSafety(
        @Path("town-id") townId : Int
    ) : SeollyongdanBaseResponse<ResponseHomeSafetyDto>

    @GET("/$API/$TOWN/{town-id}/$PROPERTIES")
    suspend fun getTownRealEstate(
        @Path("town-id") townId : Int
    ) : SeollyongdanBaseResponse<ResponseRealEstateDto>
}