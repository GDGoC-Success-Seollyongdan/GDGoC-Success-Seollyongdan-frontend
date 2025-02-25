package com.example.seollyongdan_frontend.data.dto.request

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class RequestLoginDto (
    @SerialName("username") val id: String,
    @SerialName("password") val password : String
)