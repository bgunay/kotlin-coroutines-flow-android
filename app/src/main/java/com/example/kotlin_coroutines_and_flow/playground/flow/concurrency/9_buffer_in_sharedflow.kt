package com.example.kotlin_coroutines_and_flow.playground.flow.concurrency

import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.launch
import kotlin.system.measureTimeMillis

suspend fun main(): Unit = coroutineScope {

    val flow = MutableSharedFlow<Int>(extraBufferCapacity = 10)

    // Collector 1
    launch {
        flow.collect {
            println("Collector 1 processes $it")
        }
    }

    // Collector 2
    launch {
        flow.collect {
            println("Collector 2 processes $it")
            delay(100)
        }
    }

    // Emitter
    launch {
        val timeToEmit = measureTimeMillis {
            repeat(5) {
                flow.emit(it)
                delay(10)
            }
        }
        println("Time to emit all values: $timeToEmit ms")
    }
}