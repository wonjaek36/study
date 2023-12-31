package chapter2.summary

import appendix.atomictest.*

// 일반적으로 마지막 파라미터를 vararg로 선언
fun varargs(s: String, vararg ints: Int) {
    for (i in ints) {
        trace("$i")
    }
    trace(s)
}

fun main() {
    varargs("primes", 5, 7, 11, 13, 17, 19, 23)
    trace eq """
        5
        7
        11
        13
        17
        19
        23
        primes
    """.trimIndent()
}