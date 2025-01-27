package com.example.seollyongdan_frontend.domain.repository

import com.example.seollyongdan_frontend.domain.entity.ExampleEntity

interface ExampleRepository {
    suspend fun getUsers(page: Int): Result<List<ExampleEntity>>
}