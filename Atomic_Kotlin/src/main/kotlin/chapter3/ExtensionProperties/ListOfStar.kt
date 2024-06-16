package chapter3.ExtensionProperties

import appendix.atomictest.eq

// Generic Type을 쓰지 않으면, Star projection으로 대신할 수 있음
val List<*>.indices: IntRange
    get() = 0 until size

fun main() {
    listOf(1).indices eq 0..0
    listOf('a', 'b', 'c', 'd').indices eq 0..3
    emptyList<Int>().indices eq IntRange.EMPTY
}