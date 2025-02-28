package com.example.seollyongdan_frontend.data.datasource

import com.example.seollyongdan_frontend.data.dto.SeollyongdanBaseResponse
import com.example.seollyongdan_frontend.data.dto.request.RequestSearchFilterDto
import com.example.seollyongdan_frontend.data.dto.response.ResponseSearchFilterDto

interface SearchDataSource {
    suspend fun postSearchFilter(requestSearchFilterDto: RequestSearchFilterDto): SeollyongdanBaseResponse<ResponseSearchFilterDto>
}