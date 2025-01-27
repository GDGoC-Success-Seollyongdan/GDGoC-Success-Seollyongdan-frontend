package com.example.seollyongdan_frontend.data.datasourceimpl

import com.example.seollyongdan_frontend.data.datasource.ExampleDataSource
import com.example.seollyongdan_frontend.data.dto.ExampleBaseResponse
import com.example.seollyongdan_frontend.data.dto.response.ResponseGetExampleDto
import com.example.seollyongdan_frontend.data.service.ExampleApiService
import javax.inject.Inject

class ExampleDataSourceImpl @Inject constructor(
    private val exampleApiService: ExampleApiService
) : ExampleDataSource {
    override suspend fun getUsers(page: Int): ExampleBaseResponse<List<ResponseGetExampleDto>> {
        return exampleApiService.getUsers(page)
    }
}