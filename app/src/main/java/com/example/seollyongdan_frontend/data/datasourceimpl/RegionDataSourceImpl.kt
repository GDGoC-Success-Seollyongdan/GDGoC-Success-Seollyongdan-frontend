package com.example.seollyongdan_frontend.data.datasourceimpl

import com.example.seollyongdan_frontend.data.datasource.RegionDataSource
import com.example.seollyongdan_frontend.data.dto.response.RegionDto
import com.example.seollyongdan_frontend.data.service.RegionApiService
import javax.inject.Inject

class RegionDataSourceImpl @Inject constructor(
    private val regionApiService: RegionApiService
) : RegionDataSource {
    override suspend fun fetchRegions(page: Int, perPage: Int): List<RegionDto> {
        return regionApiService.getRegions(page, perPage).data
    }
}