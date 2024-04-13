package com.example.kotlin_coroutines_and_flow.usecases.coroutines.usecase7.callbacks

import com.example.kotlin_coroutines_and_flow.mock.VersionFeatures

sealed class UiState {
    object Loading : UiState()
    data class Success(val versionFeatures: List<VersionFeatures>) : UiState()
    data class Error(val message: String) : UiState()
}