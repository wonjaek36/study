package chapter4.ImportanceOfLambdas

import appendix.atomictest.eq

fun main() {
    val list = listOf(1, 5, 7, 10)
    val divider = 5
    list.filter { it % divider == 0 }
        .sum() eq 15
}