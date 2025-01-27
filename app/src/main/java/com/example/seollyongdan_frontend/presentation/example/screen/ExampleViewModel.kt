package com.example.seollyongdan_frontend.presentation.example.screen

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.seollyongdan_frontend.domain.entity.ExampleEntity
import com.example.seollyongdan_frontend.domain.repository.ExampleRepository
import com.example.seollyongdan_frontend.util.UiState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ExampleViewModel @Inject constructor(
    val exampleRepository: ExampleRepository
) : ViewModel() {
    private val _getExampleState = MutableStateFlow<UiState<List<ExampleEntity>>>(UiState.Empty)
    val getExampleState: StateFlow<UiState<List<ExampleEntity>>> = _getExampleState

    init {
        getUsers(PAGE)
    }

    fun getUsers(page: Int) = viewModelScope.launch {
        _getExampleState.emit(UiState.Loading)
        exampleRepository.getUsers(page).fold(
            {
                if (it.isNotEmpty()) _getExampleState.emit(UiState.Success(it)) else _getExampleState.emit(
                    UiState.Failure("400")
                )
            },
            { _getExampleState.emit(UiState.Failure(it.message.toString())) }
        )
    }

    companion object {
        private const val PAGE = 2
    }
}