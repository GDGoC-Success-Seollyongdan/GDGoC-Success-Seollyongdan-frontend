package com.example.seollyongdan_frontend.presentation.home.screen

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
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
class SafetyVisualizationViewModel @Inject constructor(
    private val repository: HomeRepository
) : ViewModel() {

    private val _highCrimeIndexes = MutableStateFlow<List<Int>>(emptyList())
    val highCrimeIndexes: StateFlow<List<Int>> = _highCrimeIndexes.asStateFlow()

    private val _lowCrimeIndexes = MutableStateFlow<List<Int>>(emptyList())
    val lowCrimeIndexes: StateFlow<List<Int>> = _lowCrimeIndexes.asStateFlow()

    private val _otherCrimeIndexes = MutableStateFlow<List<Int>>(emptyList())
    val otherCrimeIndexes: StateFlow<List<Int>> = _otherCrimeIndexes.asStateFlow()

    fun getCrimeFreq() {
        viewModelScope.launch {
            val result = repository.getHomeCrimeFreq()
            result.onSuccess { crimeFreqList ->
                // 새로운 리스트를 생성하고 분류
                val highList = mutableListOf<Int>()
                val lowList = mutableListOf<Int>()
                val otherList = mutableListOf<Int>()

                // "높음", "낮음", "기타"에 맞는 인덱스를 분류
                crimeFreqList.forEachIndexed { index, value ->
                    when (value) {
                        "높음" -> highList.add(index + 1)
                        "낮음" -> lowList.add(index + 1)
                        else -> otherList.add(index + 1)
                    }
                }

                // StateFlow 값을 업데이트
                _highCrimeIndexes.value = highList
                _lowCrimeIndexes.value = lowList
                _otherCrimeIndexes.value = otherList
            }.onFailure { exception ->
                // 실패 처리
                Log.e("SafetyVisualization", "Failed to load crime frequencies: ${exception.message}")
            }
        }
    }
}