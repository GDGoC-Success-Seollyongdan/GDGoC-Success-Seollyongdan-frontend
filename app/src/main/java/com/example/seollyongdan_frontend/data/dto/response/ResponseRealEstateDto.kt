package com.example.seollyongdan_frontend.data.dto.response

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class ResponseRealEstateDto (
    @SerialName("townId") val townId: Int,
    @SerialName("monthlyRent") val monthlyRent: Float,
    @SerialName("yearlyRent") val yearlyRent: Float,
    @SerialName("saleData") val saleData: List<Float>,
    @SerialName("priceDifference1y") val priceDifference1y: Float
)