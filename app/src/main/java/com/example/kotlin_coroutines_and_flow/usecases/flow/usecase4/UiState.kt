package com.example.kotlin_coroutines_and_flow.usecases.flow.usecase4

import com.example.kotlin_coroutines_and_flow.usecases.flow.mock.Stock

sealed class UiState {
    object Loading : UiState()
    data class Success(val stockList: List<Stock>) : UiState()
    data class Error(val message: String) : UiState()
}