package com.example.seollyongdan_frontend.data.repositoryimpl

import com.example.seollyongdan_frontend.app.di.RegionRetrofit
import com.example.seollyongdan_frontend.data.datasource.RegionDataSource
import com.example.seollyongdan_frontend.data.dto.response.RegionDto
import com.example.seollyongdan_frontend.domain.repository.RegionRepository
import retrofit2.Retrofit
import javax.inject.Inject

class RegionRepositoryImpl @Inject constructor(
    private val regionDataSource: RegionDataSource
) : RegionRepository {
    override suspend fun getRegions(page: Int, perPage: Int): List<RegionDto> {
        return regionDataSource.fetchRegions(page, perPage)
    }
}