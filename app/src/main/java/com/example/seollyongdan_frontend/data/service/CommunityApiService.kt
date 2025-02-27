package com.example.seollyongdan_frontend.data.service

import com.example.seollyongdan_frontend.data.dto.SeollyongdanBaseResponse
import com.example.seollyongdan_frontend.data.dto.request.RequestCommentPostDto
import com.example.seollyongdan_frontend.data.dto.request.RequestCommunityNewPostDto
import com.example.seollyongdan_frontend.data.dto.response.ResponseCommunityPostCommentDto
import com.example.seollyongdan_frontend.data.dto.response.ResponseCommunityPostDto
import com.example.seollyongdan_frontend.data.service.ApiKeyStorage.COMMENTS
import com.example.seollyongdan_frontend.data.service.ApiKeyStorage.DISTRICT
import com.example.seollyongdan_frontend.data.service.ApiKeyStorage.POSTS
import com.example.seollyongdan_frontend.data.service.ApiKeyStorage.SEARCH
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path
import retrofit2.http.Query

interface CommunityApiService {

    @GET("/$POSTS/$DISTRICT/{district}")
    suspend fun getAllPosts(
        @Path("district") district : String
    ) : SeollyongdanBaseResponse<List<ResponseCommunityPostDto>>

    @POST("/$POSTS")
    suspend fun postNewPost(
        @Body requestCommunityNewPostDto: RequestCommunityNewPostDto
    ) : SeollyongdanBaseResponse<Unit>

    @GET("/$POSTS/{postId}/$COMMENTS")
    suspend fun getPostComments(
        @Path("postId") postId : Int
    ) : SeollyongdanBaseResponse<List<ResponseCommunityPostCommentDto>>

    @GET("/$POSTS/{postId}")
    suspend fun getPostDetail(
        @Path("postId") postId: Int
    ) : SeollyongdanBaseResponse<ResponseCommunityPostDto>

    @GET("/$POSTS/{postId}/$COMMENTS")
    suspend fun postComment(
        @Path("postId") postId: Int,
        @Body requestCommentPostDto: RequestCommentPostDto
    ) : SeollyongdanBaseResponse<Unit>


    @GET("/$POSTS/$SEARCH")
    suspend fun getPostSearch(
        @Query("district") district: String,
        @Query("keyword") keyword: String
    ): SeollyongdanBaseResponse<List<ResponseCommunityPostDto>>
}