package chapter2.summary

import appendix.atomictest.*

fun main() {
    val ints = listOf(5, 13, 9)
    for (i in ints) {
        if (i > 10) {
            trace(i)
        }
    }

    val chars = mutableListOf('a', 'b' ,'c')
    chars.add('d')
    chars += 'e'
    trace(chars)
    trace eq """
        13
        [a, b, c, d, e]
    """.trimIndent()
}