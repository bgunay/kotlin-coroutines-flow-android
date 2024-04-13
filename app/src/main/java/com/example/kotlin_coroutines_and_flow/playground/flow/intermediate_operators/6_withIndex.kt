package com.example.kotlin_coroutines_and_flow.playground.flow.intermediate_operators

import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.flow.withIndex

suspend fun main() {

    flowOf(1, 2, 3, 4, 5, 1)
        .withIndex()
        .collect { collectedValue ->
            println(collectedValue)
        }

}