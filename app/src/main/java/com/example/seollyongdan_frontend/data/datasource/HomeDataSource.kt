package com.example.seollyongdan_frontend.data.datasource

import com.example.seollyongdan_frontend.data.dto.SeollyongdanBaseResponse
import com.example.seollyongdan_frontend.data.dto.response.ResponseHomeCongestionDto
import com.example.seollyongdan_frontend.data.dto.response.ResponseHomeCrimeFreqDto
import com.example.seollyongdan_frontend.data.dto.response.ResponseHomeSafetyDto
import com.example.seollyongdan_frontend.data.dto.response.ResponseRealEstateDto
import com.example.seollyongdan_frontend.data.dto.response.ResponseHomeTrafficDto
import com.example.seollyongdan_frontend.data.dto.response.ResponseLifeDto

interface HomeDataSource {

    suspend fun getHomeSafety(townId : Int) : SeollyongdanBaseResponse<ResponseHomeSafetyDto>

    suspend fun getHomeRealEstate(townId: Int) : SeollyongdanBaseResponse<ResponseRealEstateDto>

    suspend fun getHomeTraffic(townId: Int) : SeollyongdanBaseResponse<ResponseHomeTrafficDto>

    suspend fun getHomeCrimeFreq() : SeollyongdanBaseResponse<ResponseHomeCrimeFreqDto>

    suspend fun getHomeCongestion() : SeollyongdanBaseResponse<ResponseHomeCongestionDto>

    suspend fun getHomeLife(townId: Int): SeollyongdanBaseResponse<ResponseLifeDto>
}