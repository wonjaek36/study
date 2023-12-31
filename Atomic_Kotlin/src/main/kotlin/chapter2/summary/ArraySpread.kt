package chapter2.summary

import appendix.atomictest.*


fun main() {
    val array = intArrayOf(4, 5)
    // varargs("x", 1, 2, 3, *array, 6)
    // cause error

    val list = listOf(9, 10, 11)
    varargs(
        "y", 7, 8, *list.toIntArray())
    trace eq """
        7
        8
        9
        10
        11
        y
    """.trimIndent()
}