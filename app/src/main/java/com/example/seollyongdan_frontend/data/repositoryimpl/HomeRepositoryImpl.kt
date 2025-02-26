package com.example.seollyongdan_frontend.data.repositoryimpl

import com.example.seollyongdan_frontend.data.datasource.HomeDataSource
import com.example.seollyongdan_frontend.data.dto.response.ResponseHomeSafetyDto
import com.example.seollyongdan_frontend.data.dto.response.ResponseRealEstateDto
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
}