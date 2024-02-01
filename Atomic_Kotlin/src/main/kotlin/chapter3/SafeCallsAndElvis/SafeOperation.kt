package chapter3.SafeCallsAndElvis

import appendix.atomictest.*

fun String.echo() {
    trace(uppercase()) // toUpperCase deprecated
    trace(this)
    trace(lowercase()) // toLowerCase deprecated
}

fun main() {
    val s1: String? = "Howdy!"
    s1?.echo()
    val s2: String? = null
    s2?.echo()

    trace eq """
        HOWDY!
        Howdy!
        howdy!
    """.trimIndent()
}