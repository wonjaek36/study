package chapter4.Lambdas

import appendix.atomictest.eq

fun main() {
    val list = listOf(1, 2, 3, 4)
    val result = list.map({ "[$it]" })
    result eq listOf("[1]", "[2]", "[3]", "[4]")
}