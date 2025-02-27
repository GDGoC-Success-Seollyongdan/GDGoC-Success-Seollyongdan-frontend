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
class SafetyViewModel @Inject constructor(
    private val repository: HomeRepository
) : ViewModel() {

    private val _crimeData = MutableStateFlow<List<Float>?>(null)
    val crimeData: StateFlow<List<Float>?> = _crimeData.asStateFlow()

    private val _cctvCount = MutableStateFlow<String?>(null)
    val cctvCount: StateFlow<String?> = _cctvCount.asStateFlow()

    private val _policeStationsCount = MutableStateFlow<String?>(null)
    val policeStationsCount: StateFlow<String?> = _policeStationsCount.asStateFlow()

    private val _fireStationsCount = MutableStateFlow<String?>(null)
    val fireStationsCount: StateFlow<String?> = _fireStationsCount.asStateFlow()

    private val _isSafe = MutableStateFlow(false)
    val isSafe: StateFlow<Boolean> = _isSafe.asStateFlow()

    fun getHomeSafety(townId: Int) {
        viewModelScope.launch {
            val result = repository.getHomeSafety(townId)
            result.onSuccess { response ->
                _crimeData.value = response.crimeData?.map { it.toFloat() }
                _cctvCount.value = response.cctvCount?.toString()
                _policeStationsCount.value = response.policeStations?.toString()
                _fireStationsCount.value = response.fireStations?.toString()
                _isSafe.value = response.isSafe
            }.onFailure {
                // 오류 처리 로직
            }
        }
    }
}