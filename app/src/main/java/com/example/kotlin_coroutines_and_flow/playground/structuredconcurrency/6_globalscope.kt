package com.example.kotlin_coroutines_and_flow.playground.structuredconcurrency

import kotlinx.coroutines.*

fun main() = runBlocking {

    println("Job of GlobalScope: ${GlobalScope.coroutineContext[Job]}")

    val coroutineExceptionHandler = CoroutineExceptionHandler { context, throwable ->

    }
    val job = GlobalScope.launch(coroutineExceptionHandler) {
        val child = launch {
            delay(50)
            throw RuntimeException()
            println("Still running")
            delay(50)
            println("Still running")
            delay(50)
            println("Still running")
            delay(50)
            println("Still running")
        }
    }

    delay(100)

    job.cancel()

    delay(300)

}