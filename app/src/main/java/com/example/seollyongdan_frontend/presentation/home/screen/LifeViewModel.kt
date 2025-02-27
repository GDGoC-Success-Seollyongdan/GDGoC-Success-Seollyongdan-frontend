package com.example.seollyongdan_frontend.presentation.home.screen

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

    private var _top1Commercial: String? = null
    val top1Commercial: String? get() = _top1Commercial

    private var _top2Commercial: String? = null
    val top2Commercial: String? get() = _top2Commercial

    private var _top3Commercial: String? = null
    val top3Commercial: String? get() = _top3Commercial

    private var _top4Commercial: String? = null
    val top4Commercial: String? get() = _top4Commercial

    private var _top5Commercial: String? = null
    val top5Commercial: String? get() = _top5Commercial

    private var _top1Count: Int? = 0
    val top1Count: Int? get() = _top1Count

    private var _top2Count: Int? = 0
    val top2Count: Int? get() = _top2Count

    private var _top3Count: Int? = 0
    val top3Count: Int? get() = _top3Count

    private var _top4Count: Int? = 0
    val top4Count: Int? get() = _top4Count

    private var _top5Count: Int? = 0
    val top5Count: Int? get() = _top5Count

    private var _isCulturalArea: Boolean? = false
    val isCulturalArea: Boolean? get() = _isCulturalArea

    fun getHomeLife(townId: Int) {
        viewModelScope.launch {
            val result = repository.getHomeLife(townId)
            result.onSuccess {  response ->
                _top1Commercial = response.top1Commercial?.toString()
                _top2Commercial = response.top2Commercial?.toString()
                _top3Commercial = response.top3Commercial?.toString()
                _top4Commercial = response.top4Commercial?.toString()
                _top5Commercial = response.top5Commercial?.toString()
                _top1Count = response.top1Count?.toInt()
                _top2Count = response.top2Count?.toInt()
                _top3Count = response.top3Count?.toInt()
                _top4Count = response.top4Count?.toInt()
                _top5Count = response.top5Count?.toInt()
                _isCulturalArea = response.isCulturalArea
            }.onFailure {

            }
        }
    }
}