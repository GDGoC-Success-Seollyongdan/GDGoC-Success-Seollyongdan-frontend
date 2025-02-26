package com.example.seollyongdan_frontend.data.repositoryimpl

import com.example.seollyongdan_frontend.data.datasource.HomeDataSource
import com.example.seollyongdan_frontend.data.dto.response.CrimeFreqDto
import com.example.seollyongdan_frontend.data.dto.response.ResponseHomeCrimeFreqDto
import com.example.seollyongdan_frontend.data.dto.response.ResponseHomeSafetyDto
import com.example.seollyongdan_frontend.data.dto.response.ResponseHomeTrafficDto
import com.example.seollyongdan_frontend.domain.repository.HomeRepository
import javax.inject.Inject

class HomeRepositoryImpl @Inject constructor(
    private val homeDataSource: HomeDataSource
) : HomeRepository {

    override suspend fun getHomeSafety(townId: Int): Result<ResponseHomeSafetyDto> {
        return runCatching {
            val response = homeDataSource.getHomeSafety(townId)

            val result = response.result ?: throw Exception("Result is null")


            ResponseHomeSafetyDto(
                townId = result.townId,
                crimeData = result.crimeData,
                cctvCount = result.cctvCount,
                policeStations = result.policeStations,
                fireStations = result.fireStations,
                isSafe = result.isSafe
            )
        }
    }

    override suspend fun getHomeTraffic(townId: Int): Result<ResponseHomeTrafficDto> {
        return runCatching {
            val response = homeDataSource.getHomeTraffic(townId)

            val result = response.result ?: throw Exception("Result is null")

            ResponseHomeTrafficDto(
                townId = result.townId,
                busRatio = result.busRatio,
                subwayRatio = result.subwayRatio,
                taxiRatio = result.taxiRatio,
                mostUsedTransport = result.mostUsedTransport,
                isHigh = result.isHigh
            )
        }
    }

    override suspend fun getHomeCrimeFreq(): Result<List<String>> {
        return runCatching {
            val response = homeDataSource.getHomeCrimeFreq()

            val result = response.result ?: throw Exception("Result is null")

            result.crimeFrequency.map { it.crimeFrequency }
        }
    }

    override suspend fun getHomeCongestion(): Result<List<String>> {
        return kotlin.runCatching {
            val response = homeDataSource.getHomeCongestion()
            val result = response.result ?: throw Exception("Result is null")

            result.roadCongestion.map { it.roadCongestion }

        }
    }

}