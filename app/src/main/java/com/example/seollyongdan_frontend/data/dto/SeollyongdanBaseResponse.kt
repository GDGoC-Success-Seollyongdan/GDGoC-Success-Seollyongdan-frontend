package com.example.seollyongdan_frontend.data.dto

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class SeollyongdanBaseResponse<T>(
    @SerialName("httpStatus") val httpStatus : String,
    @SerialName("success") val success : Boolean,
    @SerialName("result") val result: T? = null,
    @SerialName("error") val error : String?
)
