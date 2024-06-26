package chapter4.OperationsOnCollections

import appendix.atomictest.eq

fun createPair() = Pair(1, "one")

fun main() {

    val (i, s) = createPair()
    i eq 1
    s eq "one"
}