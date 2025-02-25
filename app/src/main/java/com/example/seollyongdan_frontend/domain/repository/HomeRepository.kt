package com.example.seollyongdan_frontend.domain.repository

import com.example.seollyongdan_frontend.data.dto.response.ResponseHomeSafetyDto

interface HomeRepository {

    suspend fun getHomeSafety(townId : Int) : Result<ResponseHomeSafetyDto>


}