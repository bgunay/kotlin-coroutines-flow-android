package com.example.kotlin_coroutines_and_flow.playground.coroutinebuilders

import kotlinx.coroutines.async
import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking

fun main() = runBlocking {

    val startTime = System.currentTimeMillis()

    val deferred1 = async {
        val result1 = com.example.kotlin_coroutines_and_flow.playground.coroutinebuilders.networkCall(
            1
        ).also {
            println("result received: $it after ${
                com.example.kotlin_coroutines_and_flow.playground.coroutinebuilders.elapsedMillis(
                    startTime
                )
            }ms")
        }
        result1
    }

    val deferred2 = async {
        val result2 =
            com.example.kotlin_coroutines_and_flow.playground.coroutinebuilders.networkCall(2)
        println("result received: $result2 after ${
            com.example.kotlin_coroutines_and_flow.playground.coroutinebuilders.elapsedMillis(
                startTime
            )
        }ms")
        result2
    }

    val resultList = listOf(deferred1.await(), deferred2.await())

    println("Result list: $resultList after ${
        com.example.kotlin_coroutines_and_flow.playground.coroutinebuilders.elapsedMillis(
            startTime
        )
    }ms")
}

suspend fun networkCall(number: Int): String {
    delay(500)
    return "Result $number"
}

fun elapsedMillis(startTime: Long) = System.currentTimeMillis() - startTime
