package com.example.seollyongdan_frontend.data.repositoryimpl

import com.example.seollyongdan_frontend.data.datasource.ExampleDataSource
import com.example.seollyongdan_frontend.data.mapper.toExampleEntity
import com.example.seollyongdan_frontend.domain.entity.ExampleEntity
import com.example.seollyongdan_frontend.domain.repository.ExampleRepository
import javax.inject.Inject

class ExampleRepositoryImpl @Inject constructor(
    private val exampleDataSource: ExampleDataSource
) : ExampleRepository {
    override suspend fun getUsers(page: Int): Result<List<ExampleEntity>> {
        return runCatching {
            exampleDataSource.getUsers(page).data?.map { it.toExampleEntity() } ?: emptyList()
        }
    }
}