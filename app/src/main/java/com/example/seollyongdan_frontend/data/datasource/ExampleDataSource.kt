package com.example.seollyongdan_frontend.data.datasource

import com.example.seollyongdan_frontend.data.dto.ExampleBaseResponse
import com.example.seollyongdan_frontend.data.dto.response.ResponseGetExampleDto

interface ExampleDataSource {
    suspend fun getUsers(page: Int): ExampleBaseResponse<List<ResponseGetExampleDto>>
}