package com.example.seollyongdan_frontend.data.datasourceimpl

import com.example.seollyongdan_frontend.data.datasource.CommunityDataSource
import com.example.seollyongdan_frontend.data.dto.SeollyongdanBaseResponse
import com.example.seollyongdan_frontend.data.dto.request.RequestCommentPostDto
import com.example.seollyongdan_frontend.data.dto.request.RequestCommunityNewPostDto
import com.example.seollyongdan_frontend.data.dto.response.ResponseCommunityPostCommentDto
import com.example.seollyongdan_frontend.data.dto.response.ResponseCommunityPostDto
import com.example.seollyongdan_frontend.data.service.CommunityApiService
import javax.inject.Inject

class CommunityDataSourceImpl @Inject constructor(
    private val communityApiService: CommunityApiService
) : CommunityDataSource {

    override suspend fun getAllPosts(district : String): SeollyongdanBaseResponse<List<ResponseCommunityPostDto>> {
        return communityApiService.getAllPosts(district)
    }

    override suspend fun postNewPost(requestCommunityNewPostDto: RequestCommunityNewPostDto): SeollyongdanBaseResponse<Unit> {
        return communityApiService.postNewPost(requestCommunityNewPostDto)
    }

    override suspend fun getPostComments(postId: Int): SeollyongdanBaseResponse<List<ResponseCommunityPostCommentDto>> {
        return communityApiService.getPostComments(postId)
    }

    override suspend fun getPostDetail(postId: Int): SeollyongdanBaseResponse<ResponseCommunityPostDto> {
        return communityApiService.getPostDetail(postId)
    }

    override suspend fun postComment(postId : Int, requestCommentPostDto: RequestCommentPostDto): SeollyongdanBaseResponse<Unit> {
        return communityApiService.postComment(postId, requestCommentPostDto)
    }

    override suspend fun getPostSearch(
        district: String,
        keyword: String
    ): SeollyongdanBaseResponse<List<ResponseCommunityPostDto>> {
        return communityApiService.getPostSearch(district,keyword)
    }
}