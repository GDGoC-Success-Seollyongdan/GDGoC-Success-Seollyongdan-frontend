package com.example.seollyongdan_frontend.data.service

import com.example.seollyongdan_frontend.data.dto.SeollyongdanBaseResponse
import com.example.seollyongdan_frontend.data.dto.response.ResponseHomeCongestionDto
import com.example.seollyongdan_frontend.data.dto.response.ResponseHomeCrimeFreqDto
import com.example.seollyongdan_frontend.data.dto.response.ResponseHomeSafetyDto
import com.example.seollyongdan_frontend.data.dto.response.ResponseHomeTrafficDto
import com.example.seollyongdan_frontend.data.service.ApiKeyStorage.API
import com.example.seollyongdan_frontend.data.service.ApiKeyStorage.CONGESTION
import com.example.seollyongdan_frontend.data.service.ApiKeyStorage.CRIMEFREQ
import com.example.seollyongdan_frontend.data.service.ApiKeyStorage.SAFETY
import com.example.seollyongdan_frontend.data.service.ApiKeyStorage.TOWN
import com.example.seollyongdan_frontend.data.service.ApiKeyStorage.TRANSPORT
import retrofit2.http.GET
import retrofit2.http.Path

interface HomeApiService {

    @GET("/$API/$TOWN/{town-id}/$SAFETY")
    suspend fun getTownSafety(
        @Path("town-id") townId : Int
    ) : SeollyongdanBaseResponse<ResponseHomeSafetyDto>

    @GET("/$API/$TOWN/{town-id}/$TRANSPORT")
    suspend fun getTownTraffic(
        @Path("town-id") townId : Int
    ) : SeollyongdanBaseResponse<ResponseHomeTrafficDto>

    @GET("/$API/$TOWN/$CRIMEFREQ")
    suspend fun getHomeCrimeFreq() : SeollyongdanBaseResponse<ResponseHomeCrimeFreqDto>

    @GET("/$API/$TOWN/$CONGESTION")
    suspend fun getHomeCongestion() : SeollyongdanBaseResponse<ResponseHomeCongestionDto>
}