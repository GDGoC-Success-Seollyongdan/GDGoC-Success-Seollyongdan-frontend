package com.example.seollyongdan_frontend.domain.repository

import com.example.seollyongdan_frontend.data.dto.response.ResponseHomeCrimeFreqDto
import com.example.seollyongdan_frontend.data.dto.response.ResponseHomeSafetyDto
import com.example.seollyongdan_frontend.data.dto.response.ResponseRealEstateDto
import com.example.seollyongdan_frontend.data.dto.response.ResponseHomeTrafficDto

interface HomeRepository {

    suspend fun getHomeSafety(townId : Int) : Result<ResponseHomeSafetyDto>
    suspend fun getHomeRealEstate(townId: Int) : Result<ResponseRealEstateDto>

    suspend fun getHomeTraffic(townId : Int) : Result<ResponseHomeTrafficDto>

    suspend fun getHomeCrimeFreq() : Result<List<String>>

    suspend fun getHomeCongestion() : Result<List<String>>

}