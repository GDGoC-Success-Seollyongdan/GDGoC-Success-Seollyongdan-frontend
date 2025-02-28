package com.example.seollyongdan_frontend.data.dto.request

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class RequestSearchFilterDto (
    @SerialName("safety") val safety: String,
    @SerialName("traffic") val traffic: String,
    @SerialName("real_estate") val realEstate: String,
    @SerialName("amenities") val amenities: String
)