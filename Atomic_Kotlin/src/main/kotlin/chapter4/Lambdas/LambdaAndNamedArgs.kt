package chapter4.Lambdas

import appendix.atomictest.eq

fun main() {

    val list = listOf(9, 11, 23, 32)
    list.joinToString(
        separator = " ",
        // 인자로 호출한다면 중괄호({})로 감싸야한다.
        transform = { "[$it]" }
    ) eq "[9] [11] [23] [32]"
}