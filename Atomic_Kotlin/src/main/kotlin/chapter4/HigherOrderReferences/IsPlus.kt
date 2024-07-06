package chapter4.HigherOrderReferences

import appendix.atomictest.eq

val isPlus: (Int) -> Boolean = { it > 0 }
// 인자로 함수(Int): Boolean 을 받는다.

fun main() {
    listOf(1, 2, -3).any(isPlus) eq true
}
