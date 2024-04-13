package com.example.kotlin_coroutines_and_flow.playground.coroutinebuilders

import kotlinx.coroutines.CoroutineStart
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

fun main() = runBlocking {
    val job = launch(start = CoroutineStart.LAZY) {
        com.example.kotlin_coroutines_and_flow.playground.coroutinebuilders.networkRequest()
        println("result received")
    }
    delay(200)
    job.start()
    println("end of runBlocking")
}

suspend fun networkRequest() {
    delay(100)
}