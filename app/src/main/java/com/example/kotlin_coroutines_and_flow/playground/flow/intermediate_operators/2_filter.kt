package com.example.kotlin_coroutines_and_flow.playground.flow.intermediate_operators

import kotlinx.coroutines.flow.filterIsInstance
import kotlinx.coroutines.flow.flowOf

suspend fun main() {

    flowOf(1, 2, 3, 4, 5)
        .filterIsInstance<Int>()
        .collect { collectedValue ->
            println(collectedValue)
        }

}