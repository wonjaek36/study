package chapter4.HigherOrderReferences

import appendix.atomictest.eq

val helloWorld: () -> String = { "Hello, World!" }

val sum: (Int, Int) -> Int = { x, y -> x + y }

fun main() {
    helloWorld() eq "Hello, World!"
    sum(1, 2) eq 3
}