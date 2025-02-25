package com.example.seollyongdan_frontend.presentation.home.screen

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.seollyongdan_frontend.domain.repository.HomeRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class SafetyViewModel @Inject constructor(
    private val repository: HomeRepository
) : ViewModel() {

    private var _crimeData: List<Float>? = null
    val crimeData: List<Float>? get() = _crimeData

    private var _cctvCount: String? = null
    val cctvCount: String? get() = _cctvCount

    private var _policeStationsCount: String? = null
    val policeStationsCount: String? get() = _policeStationsCount

    private var _fireStationsCount: String? = null
    val fireStationsCount: String? get() = _fireStationsCount

    private var _isSafe: Boolean = false
    val isSafe: Boolean get() = _isSafe

    fun getHomeSafety(townId: Int) {
        viewModelScope.launch {
            val result = repository.getHomeSafety(townId)
            result.onSuccess { response ->
                _crimeData = response.crimeData?.map { it.toFloat() }
                _cctvCount = response.cctvCount?.toString()
                _policeStationsCount = response.policeStations?.toString()
                _fireStationsCount = response.fireStations?.toString()
                _isSafe = response.isSafe
            }.onFailure {

            }
        }
    }
}
