package chapter4.Lambdas

import appendix.atomictest.eq

fun main() {
    val list = listOf('a', 'b', 'c')
    list.indices.map {
        "[$it]"
    } eq listOf("[0]", "[1]", "[2]")
}