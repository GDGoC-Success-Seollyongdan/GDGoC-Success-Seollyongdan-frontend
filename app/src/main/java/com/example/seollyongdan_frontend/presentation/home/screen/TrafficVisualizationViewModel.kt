package com.example.seollyongdan_frontend.presentation.home.screen

import android.util.Log
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
class TrafficVisualizationViewModel @Inject constructor(
    private val repository: HomeRepository
) : ViewModel() {

    private val _highCongestionIndexes = MutableStateFlow<List<Int>>(emptyList())
    val highCongestionIndexes: StateFlow<List<Int>> = _highCongestionIndexes.asStateFlow()

    private val _lowCongestionIndexes = MutableStateFlow<List<Int>>(emptyList())
    val lowCongestionIndexes: StateFlow<List<Int>> = _lowCongestionIndexes.asStateFlow()

    private val _otherCongestionIndexes = MutableStateFlow<List<Int>>(emptyList())
    val otherCongestionIndexes: StateFlow<List<Int>> = _otherCongestionIndexes.asStateFlow()

    fun getCongestion() {
        viewModelScope.launch {
            val result = repository.getHomeCongestion()
            result.onSuccess { congestionList ->
                // 새로운 리스트를 생성하고 분류
                val highList = mutableListOf<Int>()
                val lowList = mutableListOf<Int>()
                val otherList = mutableListOf<Int>()

                // "높음", "낮음", "기타"에 맞는 인덱스를 분류
                congestionList.forEachIndexed { index, value ->
                    when (value) {
                        "혼잡" -> highList.add(index+1)
                        "보통" -> otherList.add(index+1)
                        else -> lowList.add(index+1)
                    }
                }

                // StateFlow 값을 업데이트
                _highCongestionIndexes.value = highList
                _lowCongestionIndexes.value = lowList
                _otherCongestionIndexes.value = otherList

            }.onFailure { exception ->
                // 실패 처리
                Log.e("SafetyVisualization", "Failed to load crime frequencies: ${exception.message}")
            }
        }
    }
}
