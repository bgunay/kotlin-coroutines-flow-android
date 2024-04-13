package com.example.kotlin_coroutines_and_flow.usecases.coroutines.usecase2.rx

import com.example.kotlin_coroutines_and_flow.mock.VersionFeatures

sealed class UiState {
    object Loading : UiState()
    data class Success(
        val versionFeatures: VersionFeatures
    ) : UiState()

    data class Error(val message: String) : UiState()
}