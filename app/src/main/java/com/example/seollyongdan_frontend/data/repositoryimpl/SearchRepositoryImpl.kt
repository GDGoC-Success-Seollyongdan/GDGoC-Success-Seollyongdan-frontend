package com.example.seollyongdan_frontend.data.repositoryimpl

import com.example.seollyongdan_frontend.data.datasource.SearchDataSource
import com.example.seollyongdan_frontend.data.dto.request.RequestSearchFilterDto
import com.example.seollyongdan_frontend.data.dto.response.ResponseSearchFilterDto
import com.example.seollyongdan_frontend.domain.repository.SearchRepository
import javax.inject.Inject

class SearchRepositoryImpl @Inject constructor(
    private val searchDataSource: SearchDataSource
):SearchRepository {
    override suspend fun postSearchFilter(requestSearchFilterDto: RequestSearchFilterDto): Result<ResponseSearchFilterDto> {
        return runCatching {
            val response = searchDataSource.postSearchFilter(requestSearchFilterDto)
            val result = response.result ?: throw Exception("Result is null")

            ResponseSearchFilterDto(
                clusterId = result.clusterId,
                safety = result.safety,
                traffic = result.traffic,
                realEstate = result.realEstate,
                amenities = result.amenities,
                description = result.description,
                town = result.town,
                townDescription = result.townDescription
            )
        }
    }
}