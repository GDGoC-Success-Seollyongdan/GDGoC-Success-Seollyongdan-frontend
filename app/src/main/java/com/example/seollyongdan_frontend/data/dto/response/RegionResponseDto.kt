package com.example.seollyongdan_frontend.data.dto.response

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class RegionResponseDto(
    @SerialName("data") val data: List<RegionDto>
)

@Serializable
data class RegionDto(
    @SerialName("시도명") val city: String,
    @SerialName("시군구명") val district: String,
    @SerialName("읍면동명") val town: String
)