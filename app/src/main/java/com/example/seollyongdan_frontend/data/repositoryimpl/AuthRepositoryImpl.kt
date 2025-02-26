package com.example.seollyongdan_frontend.data.repositoryimpl

import com.example.seollyongdan_frontend.data.datasource.AuthDataSource
import com.example.seollyongdan_frontend.data.dto.request.RequestLoginDto
import com.example.seollyongdan_frontend.data.dto.request.RequestSignUpDto
import com.example.seollyongdan_frontend.data.dto.response.ResponseLoginDto
import com.example.seollyongdan_frontend.data.dto.response.ResponseSignUpDto
import com.example.seollyongdan_frontend.domain.repository.AuthRepository
import javax.inject.Inject

class AuthRepositoryImpl @Inject constructor(
    private val authDataSource: AuthDataSource
) : AuthRepository {
    override suspend fun postSignUp(requestSignUpDto: RequestSignUpDto): Result<ResponseSignUpDto> {
        return runCatching {
            val response = authDataSource.postSignUp(requestSignUpDto)

            ResponseSignUpDto(
                success = response.success,
                error = response.error
            )
        }
    }

    override suspend fun getIdDuplication(username: String): Result<ResponseSignUpDto> {
        return runCatching {
            val response = authDataSource.getIdDuplication(username)

            ResponseSignUpDto(
                success = response.success,
                error = response.error
            )
        }
    }

    override suspend fun getNicknameDuplication(nickname: String): Result<ResponseSignUpDto> {
        return runCatching {
            val response = authDataSource.getNicknameDuplication(nickname)

            ResponseSignUpDto(
                success = response.success,
                error = response.error
            )
        }
    }

    override suspend fun getLogin(requestLoginDto: RequestLoginDto): Result<ResponseLoginDto> {
        return runCatching {
            val response = authDataSource.getLogin(requestLoginDto)

            val result = response.result ?: throw Exception("Result is null")

            ResponseLoginDto(
                token = result.token
            )
        }
    }

}