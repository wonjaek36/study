package chapter4.Lambdas

import appendix.atomictest.eq

fun main() {
    val list = listOf('a', 'b', 'c', 'd')
    val result = list.map { "[${it.uppercaseChar()}]" } // map의 마지막 파라미터가 람다이므로 괄호 생략 가능
    result eq listOf("[A]", "[B]", "[C]", "[D]")
}