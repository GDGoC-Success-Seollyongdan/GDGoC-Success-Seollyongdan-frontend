package com.example.seollyongdan_frontend.data.repositoryimpl

import com.example.seollyongdan_frontend.data.datasource.SignUpDataSource
import com.example.seollyongdan_frontend.data.dto.request.RequestSignUpDto
import com.example.seollyongdan_frontend.data.dto.response.ResponseSignUpDto
import com.example.seollyongdan_frontend.domain.repository.SignUpRepository
import javax.inject.Inject
import kotlin.math.sign

class SignUpRepositoryImpl @Inject constructor(
    private val signUpDataSource: SignUpDataSource
) : SignUpRepository {
    override suspend fun postSignUp(requestSignUpDto: RequestSignUpDto): Result<ResponseSignUpDto> {
        return runCatching {
            val response = signUpDataSource.postSignUp(requestSignUpDto)

            ResponseSignUpDto(
                success = response.success,
                error = response.error
            )
        }
    }

    override suspend fun getIdDuplication(username: String): Result<ResponseSignUpDto> {
        return runCatching {
            val response = signUpDataSource.getIdDuplication(username)

            ResponseSignUpDto(
                success = response.success,
                error = response.error
            )
        }
    }

    override suspend fun getNicknameDuplication(nickname: String): Result<ResponseSignUpDto> {
        return runCatching {
            val response = signUpDataSource.getNicknameDuplication(nickname)

            ResponseSignUpDto(
                success = response.success,
                error = response.error
            )
        }
    }
}