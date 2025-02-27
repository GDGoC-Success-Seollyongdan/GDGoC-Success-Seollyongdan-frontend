package com.example.seollyongdan_frontend.data.dto.response

import kotlinx.serialization.Serializable

@Serializable
data class ResponseHomeCongestionDto(
    val roadCongestion : List<CongestionDto>
)

@Serializable
data class CongestionDto(
    val roadCongestion : String
)