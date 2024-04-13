package com.example.kotlin_coroutines_and_flow.playground.flow.terminal_operators

import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.flow

fun main() {

    //it does not execute without terminal operation
    val flow = flow {
        delay(100)

        println("Emitting first value")
        emit(1)

        delay(100)

        println("Emitting second value")
        emit(2)
    }

    val list = buildList {
        add(1)
        println("add 1 to list")

        add(2)
        println("add 2 to list")
    }

}