package com.example.seollyongdan_frontend.domain.repository

import com.example.seollyongdan_frontend.data.dto.SeollyongdanBaseResponse
import com.example.seollyongdan_frontend.data.dto.request.RequestCommentPostDto
import com.example.seollyongdan_frontend.data.dto.request.RequestCommunityNewPostDto
import com.example.seollyongdan_frontend.data.dto.response.ResponseCommunityPostCommentDto
import com.example.seollyongdan_frontend.data.dto.response.ResponseCommunityPostDto

interface CommunityRepository {

    suspend fun getAllPosts(district : String) : Result<List<ResponseCommunityPostDto>>

    suspend fun postNewPost(requestCommunityNewPostDto: RequestCommunityNewPostDto) : Result<Boolean>

    suspend fun getPostComment(postId : Int) : Result<List<ResponseCommunityPostCommentDto>>

    suspend fun getPostDetail(postId: Int) : Result<ResponseCommunityPostDto>

    suspend fun postComment(postId : Int, requestCommentPostDto: RequestCommentPostDto) : Result<Boolean>

    suspend fun getPostSearch(district: String, keyword : String) : Result<List<ResponseCommunityPostDto>>
}