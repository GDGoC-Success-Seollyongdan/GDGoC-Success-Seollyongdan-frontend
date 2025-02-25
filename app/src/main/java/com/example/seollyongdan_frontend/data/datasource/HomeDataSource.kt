package com.example.seollyongdan_frontend.data.datasource

import com.example.seollyongdan_frontend.data.dto.SeollyongdanBaseResponse
import com.example.seollyongdan_frontend.data.dto.response.ResponseHomeSafetyDto

interface HomeDataSource {

    suspend fun getHomeSafety(townId : Int) : SeollyongdanBaseResponse<ResponseHomeSafetyDto>


}