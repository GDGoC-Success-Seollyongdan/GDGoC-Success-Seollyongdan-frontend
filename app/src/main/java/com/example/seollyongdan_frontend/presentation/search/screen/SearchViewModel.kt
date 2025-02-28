package com.example.seollyongdan_frontend.presentation.search.screen

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.seollyongdan_frontend.data.dto.request.RequestSearchFilterDto
import com.example.seollyongdan_frontend.domain.repository.SearchRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import java.lang.Thread.State
import javax.inject.Inject

@HiltViewModel
class SearchViewModel @Inject constructor(
    private val repository: SearchRepository
): ViewModel() {
    private val _safety = MutableStateFlow<String?>(null)
    val safety: StateFlow<String?> = _safety.asStateFlow()

    private var _traffic = MutableStateFlow<String?>(null)
    val traffic: StateFlow<String?> = _traffic.asStateFlow()

    private var _realEstate = MutableStateFlow<String?>(null)
    val realEstate: StateFlow<String?> = _realEstate.asStateFlow()

    private var _amenities = MutableStateFlow<String?>(null)
    val amenities: StateFlow<String?> = _amenities.asStateFlow()

    private var _description = MutableStateFlow<String?>(null)
    val description: StateFlow<String?> = _description.asStateFlow()

    private var _town = MutableStateFlow<List<String>?>(null)
    val town: StateFlow<List<String>?> = _town.asStateFlow()

    private var _townDescription = MutableStateFlow<List<String>?>(null)
    val townDescription: StateFlow<List<String>?> = _townDescription.asStateFlow()

    fun postSearchFilter(safety: String, traffic: String, realEstate: String, amenities: String) {
        val requestSearchFilterDto = RequestSearchFilterDto(safety, traffic, realEstate, amenities)

        viewModelScope.launch {
            val result = repository.postSearchFilter(requestSearchFilterDto)
            result.onSuccess { response ->
                _safety.value = response.safety?.toString()
                _traffic.value = response.traffic?.toString()
                _realEstate.value= response.realEstate?.toString()
                _amenities.value = response.amenities?.toString()
                _description.value = response.description?.toString() ?: "설명 없음"
                _town.value = response.town?.map { it.toString() }
                _townDescription.value = response.townDescription?.map { it.toString() }
            }.onFailure {

            }
        }
    }
}