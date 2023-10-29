package chapter2.Lists

import appendix.atomictest.eq

fun getList(): List<Int> {
    return mutableListOf(1, 2, 3)
}

fun main() {
    val list = getList()  // getList return non-mutable List
    // list += 3
    list eq listOf(1, 2, 3)
}