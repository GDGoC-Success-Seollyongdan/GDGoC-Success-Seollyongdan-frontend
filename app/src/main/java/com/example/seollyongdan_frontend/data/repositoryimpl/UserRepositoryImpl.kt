package com.example.seollyongdan_frontend.data.repositoryimpl

import com.example.seollyongdan_frontend.data.datasource.UserDataSource
import com.example.seollyongdan_frontend.data.dto.response.ResponseUserDto
import com.example.seollyongdan_frontend.domain.repository.UserRepository
import javax.inject.Inject

class UserRepositoryImpl @Inject constructor(
    private val userDataSource: UserDataSource
) : UserRepository {

    override suspend fun getUserInfo(): Result<ResponseUserDto> {
        return runCatching {
            val response = userDataSource.getUserInfo()

            val result = response.result ?: throw Exception("result is null")

            ResponseUserDto(
                userId = result.userId,
                id = result.id,
                nickname = result.nickname,
                district = result.district,
                isResident = result.isResident
            )
        }
    }
}