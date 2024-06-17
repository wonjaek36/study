package chapter4.ImportanceOfLambdas

import appendix.atomictest.eq

fun main() {

    val list = listOf(1, 2, 3, 4)
    // FilterEven.kt의 if
    val even = list.filter { it % 2 == 0 }
    // GreaterThan2.kt의 if
    val greaterThan2 = list.filter { it > 2 }
    even eq listOf(2, 4)
    greaterThan2 eq listOf(3, 4)
}