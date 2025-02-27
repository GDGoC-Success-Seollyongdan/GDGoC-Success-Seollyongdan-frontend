package com.example.seollyongdan_frontend.data.dto.response

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable


@Serializable
data class ResponseCommunityPostDto (
    @SerialName("id") val postId : Int,
    @SerialName("nickName") val postNickname : String,
    @SerialName("userDistrict") val userDistrick : String,
    @SerialName("postDistrict") val postDistrict : String,
    @SerialName("isResident") val isResident : Boolean,
    @SerialName("title") val title : String,
    @SerialName("content") val content : String,
    @SerialName("postTime") val postTime : Int,
    @SerialName("likeCount") val likeCount : Int,
    @SerialName("viewCount") val viewCount : Int,
    @SerialName("commentCount") val commentCount : Int
)
