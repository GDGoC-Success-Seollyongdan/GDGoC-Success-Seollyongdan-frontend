package com.example.seollyongdan_frontend.data.dto.response

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class ResponseCommunityPostCommentDto (
    @SerialName ("commentId") val commentId : Int,
    @SerialName ("content") val content : String,
)