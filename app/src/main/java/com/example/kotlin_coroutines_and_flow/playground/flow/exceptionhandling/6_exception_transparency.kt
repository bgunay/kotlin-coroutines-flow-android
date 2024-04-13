package com.example.kotlin_coroutines_and_flow.playground.flow.exceptionhandling

import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.flow.flow

suspend fun main(): Unit = coroutineScope {

    flow {
        try {
            emit(1)
        } catch (e: Exception) {
            println("Catch exception in flow builder.")
        }
    }.collect { emittedValue ->
        throw Exception("Exception in collect{}")
    }
}