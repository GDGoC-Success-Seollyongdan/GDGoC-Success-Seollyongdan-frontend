package com.example.seollyongdan_frontend.data.service

import com.example.seollyongdan_frontend.data.dto.SeollyongdanBaseResponse
import com.example.seollyongdan_frontend.data.dto.request.RequestSignUpDto
import com.example.seollyongdan_frontend.data.service.ApiKeyStorage.API
import com.example.seollyongdan_frontend.data.service.ApiKeyStorage.CHECKNICKNAME
import com.example.seollyongdan_frontend.data.service.ApiKeyStorage.SIGNUP
import com.example.seollyongdan_frontend.data.service.ApiKeyStorage.USERS
import com.example.seollyongdan_frontend.data.service.ApiKeyStorage.CHECKUSERNAME

import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Query

interface AuthApiService{

    @POST("/$API/$USERS/$SIGNUP")
    suspend fun postSignUp(
        @Body requestSignUpDto: RequestSignUpDto
    ) : SeollyongdanBaseResponse<String>

    @GET("/$API/$USERS/$CHECKUSERNAME")
    suspend fun getIdDuplication(
        @Query("username") username : String
    ) : SeollyongdanBaseResponse<String>

    @GET("/$API/$USERS/$CHECKNICKNAME")
    suspend fun getNicknameDuplication(
        @Query("nickname") nickname : String
    ) : SeollyongdanBaseResponse<String>

}