package com.example.seollyongdan_frontend.data.dto.request

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class RequestCommunityNewPostDto(
    @SerialName("nickName") val nickName : String,
    @SerialName("postDistrict") val postDistrict : String,
    @SerialName("title") val title : String,
    @SerialName("content") val content : String
)