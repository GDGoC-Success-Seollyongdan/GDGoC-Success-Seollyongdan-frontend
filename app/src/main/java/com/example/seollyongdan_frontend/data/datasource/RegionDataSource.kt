package com.example.seollyongdan_frontend.data.datasource

import com.example.seollyongdan_frontend.data.dto.response.RegionDto

interface RegionDataSource {
    suspend fun fetchRegions(page: Int, perPage: Int): List<RegionDto>
}