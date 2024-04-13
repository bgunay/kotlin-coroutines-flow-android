package com.example.kotlin_coroutines_and_flow.usecases.coroutines.usecase6

import com.example.kotlin_coroutines_and_flow.mock.AndroidVersion

sealed class UiState {
    object Loading : UiState()
    data class Success(val recentVersions: List<AndroidVersion>) : UiState()
    data class Error(val message: String) : UiState()
}