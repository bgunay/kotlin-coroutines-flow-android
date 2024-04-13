package com.example.kotlin_coroutines_and_flow.usecases.coroutines.usecase1

import com.example.kotlin_coroutines_and_flow.mock.AndroidVersion

sealed class UiState {
    data object Loading : UiState()
    data class Success(val recentVersions: List<AndroidVersion>) : UiState()
    data class Error(val message: String) : UiState()
}