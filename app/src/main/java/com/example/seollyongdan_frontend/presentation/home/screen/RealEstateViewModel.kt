package com.example.seollyongdan_frontend.presentation.home.screen

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.seollyongdan_frontend.domain.repository.HomeRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class RealEstateViewModel @Inject constructor(
    private val repository: HomeRepository
): ViewModel() {
    private var _monthlyRent: Float? = 0f
    val monthlyRent: Float? get() = _monthlyRent

    private var _yearlyRent: Float? = 0f
    val yearlyRent: Float? get() = _yearlyRent

    private var _saleData: List<Float>? = null
    val saleData: List<Float>? get() = _saleData

    private var _priceDifference1y: Float? = 0f
    val priceDifference1y: Float? get() = _priceDifference1y


    fun getHomeRealEstate(townId: Int) {
        viewModelScope.launch {
            val result = repository.getHomeRealEstate(townId)
            result.onSuccess { response ->
                Log.d("RealEstateViewModel", "API call successful: $response")
                _monthlyRent = response.monthlyRent?.toFloat()
                _yearlyRent = response.yearlyRent?.toFloat()
                _saleData = response.saleData?.map { it.toFloat() }
                _priceDifference1y = response.priceDifference1y?.toFloat()

                Log.d("RealEstateViewModel", "monthlyRent updated: ${_monthlyRent}") // Add these Logs
                Log.d("RealEstateViewModel", "yearlyRent updated: ${_yearlyRent}")
                Log.d("RealEstateViewModel", "saleData updated: ${_saleData}")
                Log.d("RealEstateViewModel", "priceDifference1y updated: ${_priceDifference1y}")
            }.onFailure {
                Log.e("RealEstateViewModel", "API call failed", it)
            }
        }
    }


}