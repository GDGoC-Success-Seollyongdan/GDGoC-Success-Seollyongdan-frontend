package com.example.seollyongdan_frontend.data.datasource

import com.example.seollyongdan_frontend.data.dto.SeollyongdanBaseResponse
import com.example.seollyongdan_frontend.data.dto.request.RequestCommentPostDto
import com.example.seollyongdan_frontend.data.dto.request.RequestCommunityNewPostDto
import com.example.seollyongdan_frontend.data.dto.response.ResponseCommunityPostCommentDto
import com.example.seollyongdan_frontend.data.dto.response.ResponseCommunityPostDto

interface CommunityDataSource {

    suspend fun getAllPosts(district : String) : SeollyongdanBaseResponse<List<ResponseCommunityPostDto>>

    suspend fun postNewPost(requestCommunityNewPostDto: RequestCommunityNewPostDto) : SeollyongdanBaseResponse<Unit>

    suspend fun getPostComments(postId : Int) : SeollyongdanBaseResponse<List<ResponseCommunityPostCommentDto>>

    suspend fun getPostDetail(postId: Int) : SeollyongdanBaseResponse<ResponseCommunityPostDto>

    suspend fun postComment(postId: Int, requestCommentPostDto: RequestCommentPostDto) : SeollyongdanBaseResponse<Unit>

    suspend fun getPostSearch(district : String, keyword : String) : SeollyongdanBaseResponse<List<ResponseCommunityPostDto>>

}