package com.example.seollyongdan_frontend.data.datasourceimpl

import com.example.seollyongdan_frontend.data.datasource.HomeDataSource
import com.example.seollyongdan_frontend.data.dto.SeollyongdanBaseResponse
import com.example.seollyongdan_frontend.data.dto.response.ResponseHomeSafetyDto
import com.example.seollyongdan_frontend.data.service.HomeApiService
import javax.inject.Inject

class HomeDataSourceImpl @Inject constructor(
    private val homeApiService: HomeApiService
) : HomeDataSource {

    override suspend fun getHomeSafety(townId: Int): SeollyongdanBaseResponse<ResponseHomeSafetyDto> {
        return homeApiService.getTownSafety(townId)
    }
}