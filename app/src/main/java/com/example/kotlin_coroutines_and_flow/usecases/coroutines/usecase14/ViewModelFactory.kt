package com.example.kotlin_coroutines_and_flow.usecases.coroutines.usecase14

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

class ViewModelFactory(private val repository: AndroidVersionRepository?) :
    ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return modelClass.getConstructor(AndroidVersionRepository::class.java)
            .newInstance(repository)
    }
}