package com.example.seollyongdan_frontend.domain.repository

import com.example.seollyongdan_frontend.data.dto.response.ResponseCommunityPostDto

interface CommunityRepository {

    suspend fun getAllPosts() : Result<List<ResponseCommunityPostDto>>
}