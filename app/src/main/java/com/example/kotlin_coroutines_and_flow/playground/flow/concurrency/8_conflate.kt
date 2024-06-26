package com.example.kotlin_coroutines_and_flow.playground.flow.concurrency

import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.conflate
import kotlinx.coroutines.flow.flow

suspend fun main() = coroutineScope {

    val flow = flow {
        repeat(5) {
//            println("Emitter:    Start Cooking Pancake $it")
            delay(100)
            println("Emitter:    Pancake $it ready!")
            emit(it)
        }
    }.conflate()

    flow.collect {
  //      println("Collector:  Start eating pancake $it")
        delay(300)
        println("Collector:  Finished eating pancake $it")
    }
}