package com.example.kotlin_coroutines_and_flow.playground.flow.intermediate_operators

import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.flow.mapNotNull

suspend fun main() {

    flowOf(1, 2, 3, 4, 5)
        .mapNotNull { "Emission $it" }
        .collect { collectedValue ->
            println(collectedValue)
        }

}