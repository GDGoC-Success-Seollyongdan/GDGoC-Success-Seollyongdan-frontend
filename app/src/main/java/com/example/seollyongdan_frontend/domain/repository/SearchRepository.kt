package com.example.seollyongdan_frontend.domain.repository

import com.example.seollyongdan_frontend.data.dto.request.RequestSearchFilterDto
import com.example.seollyongdan_frontend.data.dto.response.ResponseSearchFilterDto

interface SearchRepository {

    suspend fun postSearchFilter(requestSearchFilterDto: RequestSearchFilterDto) : Result<ResponseSearchFilterDto>
}