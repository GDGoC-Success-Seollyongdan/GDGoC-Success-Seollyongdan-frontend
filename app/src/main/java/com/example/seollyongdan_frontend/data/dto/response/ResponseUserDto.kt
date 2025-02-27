package com.example.seollyongdan_frontend.data.dto.response

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable


@Serializable
data class ResponseUserDto(
    @SerialName("id") val userId : Int,
    @SerialName("username") val id : String,
    @SerialName("nickname") val nickname : String,
    @SerialName("town") val district : String,
    @SerialName("resident") val isResident : Boolean
)