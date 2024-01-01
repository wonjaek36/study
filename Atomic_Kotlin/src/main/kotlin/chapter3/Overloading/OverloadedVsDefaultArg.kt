package chapter3.Overloading

import appendix.atomictest.*

fun foo(n: Int = 99) = trace("foo-1-$n")

fun foo() {
    trace("foo-2")
    foo(14)
}

fun main() {
    // foo()의 시그니처가더 가까움
    foo()
    trace eq """
        foo-2
        foo-1-14
    """.trimIndent()
}