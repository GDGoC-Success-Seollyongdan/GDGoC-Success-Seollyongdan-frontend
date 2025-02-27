package com.example.seollyongdan_frontend.data.repositoryimpl

import com.example.seollyongdan_frontend.data.datasource.HomeDataSource
import com.example.seollyongdan_frontend.data.dto.response.CrimeFreqDto
import com.example.seollyongdan_frontend.data.dto.response.ResponseHomeCrimeFreqDto
import com.example.seollyongdan_frontend.data.dto.response.ResponseHomeSafetyDto
import com.example.seollyongdan_frontend.data.dto.response.ResponseRealEstateDto
import com.example.seollyongdan_frontend.data.dto.response.ResponseHomeTrafficDto
import com.example.seollyongdan_frontend.data.dto.response.ResponseLifeDto
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


    override suspend fun getHomeRealEstate(townId: Int): Result<ResponseRealEstateDto> {
        return runCatching {
            val response = homeDataSource.getHomeRealEstate(townId)
            val result = response.result ?: throw Exception("Result is null")

            ResponseRealEstateDto(
                townId = result.townId,
                monthlyRent = result.monthlyRent,
                yearlyRent = result.yearlyRent,
                saleData = result.saleData,
                priceDifference1y = result.priceDifference1y
            )
        }
    }

    override suspend fun getHomeLife(townId: Int): Result<ResponseLifeDto> {
        return runCatching {
            val response = homeDataSource.getHomeLife(townId)
            val result = response.result ?: throw Exception("Result is null")

            ResponseLifeDto(
                townId = result.townId,
                top1Commercial = result.top1Commercial,
                top2Commercial = result.top2Commercial,
                top3Commercial = result.top3Commercial,
                top4Commercial = result.top4Commercial,
                top5Commercial = result.top5Commercial,
                top1Count = result.top1Count,
                top2Count = result.top2Count,
                top3Count = result.top3Count,
                top4Count = result.top4Count,
                top5Count = result.top5Count,
                isCulturalArea = result.isCulturalArea
            )
        }
    }
}