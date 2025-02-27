package com.example.seollyongdan_frontend.data.datasourceimpl

import com.example.seollyongdan_frontend.data.datasource.CommunityDataSource
import com.example.seollyongdan_frontend.data.dto.SeollyongdanBaseResponse
import com.example.seollyongdan_frontend.data.dto.response.ResponseCommunityPostDto
import com.example.seollyongdan_frontend.data.service.CommunityApiService
import javax.inject.Inject

class CommunityDataSourceImpl @Inject constructor(
    private val communityApiService: CommunityApiService
) : CommunityDataSource {

    override suspend fun getAllPosts(): SeollyongdanBaseResponse<List<ResponseCommunityPostDto>> {
        return communityApiService.getAllPosts()
    }
}