package com.example.seollyongdan_frontend.data.dto.response

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class ResponseLifeDto (
    @SerialName("townId") val townId: Int,
    @SerialName("top1Commercial") val top1Commercial: String,
    @SerialName("top2Commercial") val top2Commercial: String,
    @SerialName("top3Commercial") val top3Commercial: String,
    @SerialName("top4Commercial") val top4Commercial: String,
    @SerialName("top5Commercial") val top5Commercial: String,
    @SerialName("top1Count") val top1Count: Int,
    @SerialName("top2Count") val top2Count: Int,
    @SerialName("top3Count") val top3Count: Int,
    @SerialName("top4Count") val top4Count: Int,
    @SerialName("top5Count") val top5Count: Int,
    @SerialName("culturalArea") val isCulturalArea: Boolean
)