package chapter2.Lists

import appendix.atomictest.eq

fun main() {
    // Type inferenced implicitly
    val numbers = listOf(1, 2, 3)
    val strings = listOf("one", "two", "three")

    // Type described explicitly
    val numbers2: List<Int> = listOf(1, 2, 3)
    val strings2: List<String> = listOf("one", "two", "three")
    numbers eq numbers2
    strings eq strings2
}