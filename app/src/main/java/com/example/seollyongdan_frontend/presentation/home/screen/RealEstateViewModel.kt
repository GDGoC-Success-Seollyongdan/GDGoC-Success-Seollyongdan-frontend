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
    private val _monthlyRent = MutableStateFlow<Float?>(null)
    val monthlyRent: StateFlow<Float?> = _monthlyRent

    private val _yearlyRent = MutableStateFlow<Float?>(null)
    val yearlyRent: StateFlow<Float?> = _yearlyRent

    private val _saleData = MutableStateFlow<List<Float>?>(null)
    val saleData: StateFlow<List<Float>?> = _saleData

    private val _priceDifference1y = MutableStateFlow<Float?>(null)
    val priceDifference1y: StateFlow<Float?> = _priceDifference1y


    fun getHomeRealEstate(townId: Int) {
        viewModelScope.launch {
            val result = repository.getHomeRealEstate(townId)
            result.onSuccess { response ->
                Log.d("RealEstateViewModel", "API call successful: $response")
                _monthlyRent.value = response.monthlyRent?.toFloat() ?: 0.0f
                _yearlyRent.value = response.yearlyRent?.toFloat() ?: 0.0f
                _saleData.value = response.saleData?.map { it.toFloat() } ?: emptyList()
                _priceDifference1y.value = response.priceDifference1y?.toFloat() ?: 0.0f

                Log.d("RealEstateViewModel", "monthlyRent updated: ${_monthlyRent.value}") // Add these Logs
                Log.d("RealEstateViewModel", "yearlyRent updated: ${_yearlyRent.value}")
                Log.d("RealEstateViewModel", "saleData updated: ${_saleData.value}")
                Log.d("RealEstateViewModel", "priceDifference1y updated: ${_priceDifference1y.value}")
            }.onFailure {
                Log.e("RealEstateViewModel", "API call failed", it)
            }
        }
    }


}