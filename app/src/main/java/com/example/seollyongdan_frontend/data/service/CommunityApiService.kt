package com.example.seollyongdan_frontend.data.service

import com.example.seollyongdan_frontend.data.dto.SeollyongdanBaseResponse
import com.example.seollyongdan_frontend.data.dto.response.ResponseCommunityPostDto
import com.example.seollyongdan_frontend.data.service.ApiKeyStorage.POSTS
import retrofit2.http.GET

interface CommunityApiService {

    @GET("/$POSTS")
    suspend fun getAllPosts() : SeollyongdanBaseResponse<List<ResponseCommunityPostDto>>

}