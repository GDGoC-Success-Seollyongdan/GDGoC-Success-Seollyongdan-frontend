package com.example.seollyongdan_frontend.data.dto.request

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class RequestCommentPostDto (
    @SerialName("content") val content : String
)