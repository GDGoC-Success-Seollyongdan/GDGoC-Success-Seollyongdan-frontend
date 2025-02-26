package com.example.seollyongdan_frontend.data.datasource

import com.example.seollyongdan_frontend.data.dto.SeollyongdanBaseResponse
import com.example.seollyongdan_frontend.data.dto.response.ResponseHomeSafetyDto
import com.example.seollyongdan_frontend.data.dto.response.ResponseRealEstateDto

interface HomeDataSource {

    suspend fun getHomeSafety(townId : Int) : SeollyongdanBaseResponse<ResponseHomeSafetyDto>
    suspend fun getHomeRealEstate(townId: Int) : SeollyongdanBaseResponse<ResponseRealEstateDto>
}