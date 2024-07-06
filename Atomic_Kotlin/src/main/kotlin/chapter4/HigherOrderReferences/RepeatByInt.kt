package chapter4.HigherOrderReferences

import appendix.atomictest.trace

fun main() {
    repeat(4) { trace("$it") }
    trace eq "0 1 2 3"
}