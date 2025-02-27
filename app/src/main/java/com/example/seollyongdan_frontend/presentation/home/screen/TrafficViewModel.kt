package com.example.seollyongdan_frontend.presentation.home.screen

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.seollyongdan_frontend.domain.repository.HomeRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class TrafficViewModel @Inject constructor(
    private val repository: HomeRepository
) : ViewModel() {

    private var _busRatio: Float = 0f
    val busRatio : Float = _busRatio

    private var _subwayRatio: Float = 0f
    val subwayRatio : Float = _subwayRatio

    private var _taxiRatio: Float = 0f
    val taxiRatio : Float = _taxiRatio

    private var _mostUsedTransport : String = ""
    val mostUsedTransport : String = _mostUsedTransport

    private var _isHigh : Boolean = false
    val isHigh : Boolean = _isHigh


    fun getHomeTraffic(townId: Int) {
        viewModelScope.launch {
            val result = repository.getHomeTraffic(townId)
            result.onSuccess { response ->
                _busRatio = response.busRatio
                _subwayRatio = response.subwayRatio
                _taxiRatio = response.taxiRatio
                _mostUsedTransport = response.mostUsedTransport
                _isHigh = response.isHigh
            }.onFailure {

            }
        }
    }
}
