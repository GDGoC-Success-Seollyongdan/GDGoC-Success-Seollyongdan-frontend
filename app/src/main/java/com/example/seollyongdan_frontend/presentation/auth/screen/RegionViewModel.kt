package com.example.seollyongdan_frontend.presentation.auth.screen

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.seollyongdan_frontend.data.dto.response.RegionDto
import com.example.seollyongdan_frontend.domain.repository.RegionRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class RegionViewModel @Inject constructor(
    private val repository: RegionRepository
) : ViewModel() {

    private val _regions = MutableStateFlow<List<RegionDto>>(emptyList())
    val regions: StateFlow<List<RegionDto>> = _regions

    fun fetcRegions(page: Int, perPage: Int) {
        viewModelScope.launch {
            _regions.value = repository.getRegions(page, perPage)
        }
    }
}
