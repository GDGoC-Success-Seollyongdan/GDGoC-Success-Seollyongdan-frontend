package com.example.seollyongdan_frontend.presentation.home.screen

import android.util.Log
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.seollyongdan_frontend.domain.repository.HomeRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class RealEstateViewModel @Inject constructor(
    private val repository: HomeRepository
): ViewModel() {
    private var _monthlyRent = mutableStateOf<Float?>(0f)
    val monthlyRent: State<Float?> = _monthlyRent

    private var _yearlyRent = mutableStateOf<Float?>(0f)
    val yearlyRent: State<Float?>  = _yearlyRent

    private val _saleData = MutableStateFlow<List<Float>?>(null)
    val saleData: StateFlow<List<Float>?> = _saleData.asStateFlow()

    private var _priceDifference1y = mutableStateOf<Float?>(0f)
    val priceDifference1y: State<Float?> =  _priceDifference1y



    fun getHomeRealEstate(townId: Int) {
        viewModelScope.launch {
            val result = repository.getHomeRealEstate(townId)
            result.onSuccess { response ->
                Log.d("RealEstateViewModel", "API call successful: $response")
                _monthlyRent.value = response.monthlyRent?.toFloat()
                _yearlyRent.value = response.yearlyRent?.toFloat()
                _saleData.value = response.saleData?.map { it.toFloat() }
                _priceDifference1y.value = response.priceDifference1y?.toFloat()

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