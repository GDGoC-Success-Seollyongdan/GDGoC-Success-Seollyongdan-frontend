package com.example.seollyongdan_frontend.data.datasourceimpl

import com.example.seollyongdan_frontend.data.datasource.SearchDataSource
import com.example.seollyongdan_frontend.data.dto.SeollyongdanBaseResponse
import com.example.seollyongdan_frontend.data.dto.request.RequestSearchFilterDto
import com.example.seollyongdan_frontend.data.dto.response.ResponseSearchFilterDto
import com.example.seollyongdan_frontend.data.service.SearchApiService
import javax.inject.Inject

class SearchDataSourceImpl @Inject constructor(
    private val searchApiService: SearchApiService
): SearchDataSource {
    override suspend fun postSearchFilter(requestSearchFilterDto: RequestSearchFilterDto): SeollyongdanBaseResponse<ResponseSearchFilterDto> {
        return searchApiService.postSearchFilter(requestSearchFilterDto)
    }
}