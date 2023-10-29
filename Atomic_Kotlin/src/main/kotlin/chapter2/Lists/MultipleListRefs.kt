package chapter2.Lists

import appendix.atomictest.eq

fun main() {

    val first = mutableListOf(1)
    val second: List<Int> = first
    second eq listOf(1)

    first += 2
    second eq listOf(1, 2)
    // Same identityHashCode
    System.identityHashCode(first) eq System.identityHashCode(second)
}