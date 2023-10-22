package chapter2.Testing

import appendix.atomictest.*

fun main() {
    trace("line 1")
    trace(47)
    trace("line 2")
    trace eq """
        line 1
        47
        line2
    """.trimIndent() // Error
}