package chapter4.ImportanceOfLambdas

import appendix.atomictest.eq

fun main() {
    val list = listOf(1, 5, 7, 10)
    val divider = 5
    // Inside the lambda, divider(=5) captured
    list.filter { it % divider == 0 } eq listOf(5, 10)
}