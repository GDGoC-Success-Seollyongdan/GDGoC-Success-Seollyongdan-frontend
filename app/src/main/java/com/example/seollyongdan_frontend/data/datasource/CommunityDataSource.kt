package com.example.seollyongdan_frontend.data.datasource

import com.example.seollyongdan_frontend.data.dto.SeollyongdanBaseResponse
import com.example.seollyongdan_frontend.data.dto.response.ResponseCommunityPostDto

interface CommunityDataSource {

    suspend fun getAllPosts() : SeollyongdanBaseResponse<List<ResponseCommunityPostDto>>
}