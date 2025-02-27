package com.example.seollyongdan_frontend.presentation.home.screen

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.seollyongdan_frontend.domain.repository.HomeRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SafetyVisualizationViewModel @Inject constructor(
    private val repository: HomeRepository
) : ViewModel() {

    private val _highCrimeIndexes = mutableListOf<Int>()
    val highCrimeIndexes: List<Int> get() = _highCrimeIndexes

    private val _lowCrimeIndexes = mutableListOf<Int>()
    val lowCrimeIndexes: List<Int> get() = _lowCrimeIndexes

    private val _otherCrimeIndexes = mutableListOf<Int>()
    val otherCrimeIndexes: List<Int> get() = _otherCrimeIndexes

    fun getCrimeFreq() {
        viewModelScope.launch {
            val result = repository.getHomeCrimeFreq()
            result.onSuccess { crimeFreqList ->
                // 기존에 저장된 리스트를 비우고 새로 채운다.
                _highCrimeIndexes.clear()
                _lowCrimeIndexes.clear()
                _otherCrimeIndexes.clear()

                // "높음", "낮음", "기타"에 맞는 인덱스를 분류
                crimeFreqList.forEachIndexed { index, value ->
                    when (value) {
                        "높음" -> _highCrimeIndexes.add(index+1)
                        "낮음" -> _lowCrimeIndexes.add(index+1)
                        else -> _otherCrimeIndexes.add(index+1)
                    }
                }
            }.onFailure { exception ->
                // 실패 처리
                Log.e("SafetyVisualization", "Failed to load crime frequencies: ${exception.message}")
            }
        }
    }
}
