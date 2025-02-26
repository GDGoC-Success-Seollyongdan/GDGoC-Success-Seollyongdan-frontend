package com.example.seollyongdan_frontend.data.dto.response

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class ResponseHomeSafetyDto (
    @SerialName("townId") val townId : Int,
    @SerialName("crimeData") val crimeData : List<Int>,
    @SerialName("cctvCount") val cctvCount : Int,
    @SerialName("policeStations") val policeStations : Int,
    @SerialName("fireStations") val fireStations : Int,
    @SerialName("safe") val isSafe : Boolean
)