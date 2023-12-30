package chapter2.Sets

import appendix.atomictest.eq

fun main() {
    val mutableSet = mutableSetOf<Int>()
    mutableSet += 38
    mutableSet += 38
    mutableSet eq setOf(38)
    mutableSet -= 38
    mutableSet eq setOf()
    mutableSet.size eq 0
}