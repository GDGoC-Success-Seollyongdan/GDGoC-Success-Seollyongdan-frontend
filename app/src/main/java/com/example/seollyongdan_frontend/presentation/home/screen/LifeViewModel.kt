package com.example.seollyongdan_frontend.presentation.home.screen

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.seollyongdan_frontend.domain.repository.HomeRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject
@HiltViewModel
class LifeViewModel @Inject constructor(
    private val repository: HomeRepository
): ViewModel() {

    private val _top1Commercial = mutableStateOf<String?>(null)
    val top1Commercial: State<String?> = _top1Commercial

    private val _top2Commercial = mutableStateOf<String?>(null)
    val top2Commercial: State<String?> = _top2Commercial

    private val _top3Commercial = mutableStateOf<String?>(null)
    val top3Commercial: State<String?> = _top3Commercial

    private val _top4Commercial = mutableStateOf<String?>(null)
    val top4Commercial: State<String?> = _top4Commercial

    private val _top5Commercial = mutableStateOf<String?>(null)
    val top5Commercial: State<String?> = _top5Commercial

    private val _top1Count = mutableStateOf<Int?>(0)
    val top1Count: State<Int?> = _top1Count

    private val _top2Count = mutableStateOf<Int?>(0)
    val top2Count: State<Int?> = _top2Count

    private val _top3Count = mutableStateOf<Int?>(0)
    val top3Count: State<Int?> = _top3Count

    private val _top4Count = mutableStateOf<Int?>(0)
    val top4Count: State<Int?> = _top4Count

    private val _top5Count = mutableStateOf<Int?>(0)
    val top5Count: State<Int?> = _top5Count

    private val _isCulturalArea = mutableStateOf<Boolean?>(false)
    val isCulturalArea: State<Boolean?> = _isCulturalArea

    fun getHomeLife(townId: Int) {
        viewModelScope.launch {
            val result = repository.getHomeLife(townId)
            result.onSuccess { response ->
                _top1Commercial.value = response.top1Commercial?.toString()
                _top2Commercial.value = response.top2Commercial?.toString()
                _top3Commercial.value = response.top3Commercial?.toString()
                _top4Commercial.value = response.top4Commercial?.toString()
                _top5Commercial.value = response.top5Commercial?.toString()
                _top1Count.value = response.top1Count?.toInt()
                _top2Count.value = response.top2Count?.toInt()
                _top3Count.value = response.top3Count?.toInt()
                _top4Count.value = response.top4Count?.toInt()
                _top5Count.value = response.top5Count?.toInt()
                _isCulturalArea.value = response.isCulturalArea
            }.onFailure {
                // 에러 처리 코드 추가
            }
        }
    }
}