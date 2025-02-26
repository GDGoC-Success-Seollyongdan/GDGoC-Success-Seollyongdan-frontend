package com.example.seollyongdan_frontend.data.dto.request

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class RequestSignUpDto(
    @SerialName("username") val id : String,
    @SerialName("password") val password : String,
    @SerialName("nickname") val nickName: String,
    @SerialName("town") val district : String,
)