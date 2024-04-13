package com.example.kotlin_coroutines_and_flow.playground.flow.intermediate_operators

import kotlinx.coroutines.flow.distinctUntilChanged
import kotlinx.coroutines.flow.flowOf

suspend fun main() {

    flowOf(1, 1,  2, 3, 4, 5, 1)
        .distinctUntilChanged()
        .collect { collectedValue ->
            println(collectedValue)
        }

}