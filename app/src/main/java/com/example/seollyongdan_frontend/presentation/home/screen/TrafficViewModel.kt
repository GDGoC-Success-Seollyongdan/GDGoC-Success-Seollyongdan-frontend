package com.example.seollyongdan_frontend.presentation.home.screen

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
class TrafficViewModel @Inject constructor(
    private val repository: HomeRepository
) : ViewModel() {

    private val _busRatio = MutableStateFlow(0f)
    val busRatio: StateFlow<Float> = _busRatio.asStateFlow()

    private val _subwayRatio = MutableStateFlow(0f)
    val subwayRatio: StateFlow<Float> = _subwayRatio.asStateFlow()

    private val _taxiRatio = MutableStateFlow(0f)
    val taxiRatio: StateFlow<Float> = _taxiRatio.asStateFlow()

    private val _mostUsedTransport = MutableStateFlow("")
    val mostUsedTransport: StateFlow<String> = _mostUsedTransport.asStateFlow()

    private val _isHigh = MutableStateFlow(false)
    val isHigh: StateFlow<Boolean> = _isHigh.asStateFlow()

    fun getHomeTraffic(townId: Int) {
        viewModelScope.launch {
            val result = repository.getHomeTraffic(townId)
            result.onSuccess { response ->
                _busRatio.value = response.busRatio
                _subwayRatio.value = response.subwayRatio
                _taxiRatio.value = response.taxiRatio
                _mostUsedTransport.value = response.mostUsedTransport
                _isHigh.value = response.isHigh
            }.onFailure {
                // 오류 처리 로직
            }
        }
    }
}