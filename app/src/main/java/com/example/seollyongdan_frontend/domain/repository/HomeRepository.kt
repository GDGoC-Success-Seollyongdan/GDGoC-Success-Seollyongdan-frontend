package com.example.seollyongdan_frontend.domain.repository

import com.example.seollyongdan_frontend.data.dto.response.ResponseHomeSafetyDto
import com.example.seollyongdan_frontend.data.dto.response.ResponseRealEstateDto

interface HomeRepository {

    suspend fun getHomeSafety(townId : Int) : Result<ResponseHomeSafetyDto>
    suspend fun getHomeRealEstate(townId: Int) : Result<ResponseRealEstateDto>

}