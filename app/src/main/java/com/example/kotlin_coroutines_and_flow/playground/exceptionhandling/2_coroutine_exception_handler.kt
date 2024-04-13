package com.example.kotlin_coroutines_and_flow.playground.exceptionhandling

import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch

fun main() {

    val exceptionHandler = CoroutineExceptionHandler { _, exception ->
        println("Caught $exception in CoroutineExceptionHandler")
    }

    val scope = CoroutineScope(Job())

    scope.launch (exceptionHandler) {
        launch(exceptionHandler) {
            functionThatThrowsIt2("2")
        }
    }

    Thread.sleep(100)
}

fun functionThatThrowsIt2(e:String) {
    throw Exception(e)
}