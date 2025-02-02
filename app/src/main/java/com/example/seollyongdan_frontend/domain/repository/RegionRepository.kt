package com.example.seollyongdan_frontend.domain.repository

import com.example.seollyongdan_frontend.data.dto.response.RegionDto

interface RegionRepository {
    suspend fun getRegions(page : Int, perPage : Int) : List<RegionDto>

}