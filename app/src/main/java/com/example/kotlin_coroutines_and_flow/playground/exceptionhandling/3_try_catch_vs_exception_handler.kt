package com.example.kotlin_coroutines_and_flow.playground.exceptionhandling

import kotlinx.coroutines.*

fun main() {

    val exceptionHandler = CoroutineExceptionHandler { _, throwable ->
        println("Caught exception: $throwable")
    }

    val scope = CoroutineScope(Job())

    scope.launch(exceptionHandler) {
        launch {
            println("Starting coroutine 1")
            delay(200)
            println("Coroutine 1 completed")

        }
        launch {
            println("Starting coroutine 3")
            delay(400)
            println("Coroutine 3 completed")

        }
        launch {
            println("Starting coroutine 2")
            delay(300)
            throw RuntimeException()
        }
    }

    Thread.sleep(500)

}