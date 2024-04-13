package com.example.kotlin_coroutines_and_flow.usecases.coroutines.usecase17

sealed class UiState {
    object Loading : UiState()
    data class Success(val thread: String, val duration: Long) : UiState()
    data class Error(val message: String) : UiState()
}