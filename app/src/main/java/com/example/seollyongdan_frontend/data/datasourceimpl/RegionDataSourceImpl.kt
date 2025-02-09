package com.example.seollyongdan_frontend.data.datasourceimpl

import com.example.seollyongdan_frontend.app.di.RegionRetrofit
import com.example.seollyongdan_frontend.data.datasource.RegionDataSource
import com.example.seollyongdan_frontend.data.dto.response.RegionDto
import com.example.seollyongdan_frontend.data.service.RegionApiService
import retrofit2.Retrofit
import javax.inject.Inject

class RegionDataSourceImpl @Inject constructor(
    @RegionRetrofit private val retrofit: Retrofit,
    private val regionApiKey : String
) : RegionDataSource {
    private val regionApiService: RegionApiService by lazy {
        retrofit.create(RegionApiService::class.java) // Retrofit을 통해 RegionApiService를 생성
    }

    override suspend fun fetchRegions(page: Int, perPage: Int): List<RegionDto> {
        return regionApiService.getRegions(
            serviceKey = regionApiKey,
            page, perPage).data
    }
}