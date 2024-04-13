package com.example.kotlin_coroutines_and_flow.usecases.coroutines.usecase14

import com.example.kotlin_coroutines_and_flow.mock.AndroidVersion

sealed class UiState {
    sealed class Loading : UiState() {
        object LoadFromDb : Loading()
        object LoadFromNetwork : Loading()
    }

    data class Success(val dataSource: DataSource, val recentVersions: List<AndroidVersion>) :
        UiState()

    data class Error(val dataSource: DataSource, val message: String) : UiState()
}