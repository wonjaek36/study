package chapter4.HigherOrderReferences

import appendix.atomictest.trace

fun repeat(
    times: Int,
    action: (Int) -> Unit
) {
    for (index in 0..<times) {
        action(index)
    }
}

fun main() {
    repeat(3) { trace("#$it") }
    trace eq "#0 #1 #2"
}