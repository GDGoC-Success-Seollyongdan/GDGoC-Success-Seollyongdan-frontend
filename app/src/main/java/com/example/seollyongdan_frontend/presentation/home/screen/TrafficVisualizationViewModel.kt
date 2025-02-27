package com.example.seollyongdan_frontend.presentation.home.screen

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.seollyongdan_frontend.domain.repository.HomeRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class TrafficVisualizationViewModel @Inject constructor(
    private val repository: HomeRepository
) : ViewModel() {

    private val _highCongestionIndexes = mutableListOf<Int>()
    val highCongestionIndexes: List<Int> get() = _highCongestionIndexes

    private val _lowCongestionIndexes = mutableListOf<Int>()
    val lowCongestionIndexes: List<Int> get() = _lowCongestionIndexes

    private val _otherCongestionIndexes = mutableListOf<Int>()
    val otherCongestionIndexes: List<Int> get() = _otherCongestionIndexes

    fun getCongestion() {
        viewModelScope.launch {
            val result = repository.getHomeCongestion()
            result.onSuccess { congestionList ->
                // 기존에 저장된 리스트를 비우고 새로 채운다.
                _highCongestionIndexes.clear()
                _lowCongestionIndexes.clear()
                _otherCongestionIndexes.clear()

                congestionList.forEachIndexed { index, value ->
                    when (value) {
                        "혼잡" -> _highCongestionIndexes.add(index+1)
                        "보통" -> _otherCongestionIndexes.add(index+1)
                        else -> _lowCongestionIndexes.add(index+1)

                    }
                }
            }.onFailure { exception ->
                // 실패 처리
                Log.e("SafetyVisualization", "Failed to load crime frequencies: ${exception.message}")
            }
        }
    }
}
