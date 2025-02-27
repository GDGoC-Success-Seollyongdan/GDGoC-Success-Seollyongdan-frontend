package com.example.seollyongdan_frontend.data.datasourceimpl

import com.example.seollyongdan_frontend.data.datasource.HomeDataSource
import com.example.seollyongdan_frontend.data.dto.SeollyongdanBaseResponse
import com.example.seollyongdan_frontend.data.dto.response.ResponseHomeCongestionDto
import com.example.seollyongdan_frontend.data.dto.response.ResponseHomeCrimeFreqDto
import com.example.seollyongdan_frontend.data.dto.response.ResponseHomeSafetyDto
import com.example.seollyongdan_frontend.data.dto.response.ResponseRealEstateDto
import com.example.seollyongdan_frontend.data.dto.response.ResponseHomeTrafficDto
import com.example.seollyongdan_frontend.data.dto.response.ResponseLifeDto
import com.example.seollyongdan_frontend.data.service.HomeApiService
import javax.inject.Inject

class HomeDataSourceImpl @Inject constructor(
    private val homeApiService: HomeApiService
) : HomeDataSource {

    override suspend fun getHomeSafety(townId: Int): SeollyongdanBaseResponse<ResponseHomeSafetyDto> {
        return homeApiService.getTownSafety(townId)
    }

    override suspend fun getHomeRealEstate(townId: Int): SeollyongdanBaseResponse<ResponseRealEstateDto> {
        return homeApiService.getTownRealEstate(townId)
    }

    override suspend fun getHomeTraffic(townId: Int): SeollyongdanBaseResponse<ResponseHomeTrafficDto> {
        return homeApiService.getTownTraffic(townId)
    }

    override suspend fun getHomeCrimeFreq(): SeollyongdanBaseResponse<ResponseHomeCrimeFreqDto> {
        return homeApiService.getHomeCrimeFreq()
    }

    override suspend fun getHomeCongestion(): SeollyongdanBaseResponse<ResponseHomeCongestionDto> {
        return homeApiService.getHomeCongestion()
    }

    override suspend fun getHomeLife(townId: Int): SeollyongdanBaseResponse<ResponseLifeDto> {
        return homeApiService.getHomeLife(townId)
    }
}