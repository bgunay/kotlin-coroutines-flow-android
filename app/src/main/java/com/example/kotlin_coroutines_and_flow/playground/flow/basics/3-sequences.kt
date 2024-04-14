package com.example.kotlin_coroutines_and_flow.playground.flow.basics

import com.example.kotlin_coroutines_and_flow.playground.utils.printWithTimePassed
import java.math.BigInteger

fun main() {
    val startTime = System.currentTimeMillis()
    calculateFactorialOf(5).forEach {
        printWithTimePassed(it,startTime)
    }
    println("Ready for more work!")
}

// factorial of n (n!) = 1 * 2 * 3 * 4 * ... * nkotlin-parcelize
private fun calculateFactorialOf(number: Int): Sequence<BigInteger> = sequence {
    var factorial = BigInteger.ONE
    for (i in 1..number) {
        Thread.sleep(10)
        factorial = factorial.multiply(BigInteger.valueOf(i.toLong()))
        yield(factorial)
    }
}