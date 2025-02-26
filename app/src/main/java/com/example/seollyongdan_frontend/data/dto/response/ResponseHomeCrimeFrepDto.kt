package com.example.seollyongdan_frontend.data.dto.response

import kotlinx.serialization.Serializable

@Serializable
data class ResponseHomeCrimeFreqDto(
    val crimeFrequency : List<CrimeFreqDto>
)

@Serializable
data class CrimeFreqDto(
    val crimeFrequency : String
)