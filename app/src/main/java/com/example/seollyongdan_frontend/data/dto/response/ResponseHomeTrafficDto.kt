package com.example.seollyongdan_frontend.data.dto.response

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class ResponseHomeTrafficDto(
    @SerialName("townId") val townId : Int,
    @SerialName("busRatio") val busRatio : Float,
    @SerialName("subwayRatio") val subwayRatio : Float,
    @SerialName("taxiRatio") val taxiRatio : Float,
    @SerialName("mostUsedTransport") val mostUsedTransport : String,
    @SerialName("highCongestion") val isHigh : Boolean
)