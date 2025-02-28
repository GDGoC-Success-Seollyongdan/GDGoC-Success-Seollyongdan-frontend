package com.example.seollyongdan_frontend.data.dto.response

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class ResponseSearchFilterDto (
    @SerialName("cluster_id") val clusterId: Int,
    @SerialName("safety") val safety: String,
    @SerialName("traffic") val traffic: String,
    @SerialName("real_estate") val realEstate: String,
    @SerialName("amenities") val amenities: String,
    @SerialName("description") val description: String,
    @SerialName("town") val town: List<String>,
    @SerialName("animal_description") val townDescription: List<String>
)