package chapter4.Lambdas

import appendix.atomictest.eq

fun main() {
    val list = listOf('a', 'b', 'c')
    list.mapIndexed { index, element ->
        "[$index: $element]"
    } eq listOf("[0: a]", "[1: b]", "[2: c]")
    // public inline fun <T, R> Iterable<T>.mapIndexed(
    //   transform: (index: Int, T) -> R): List<R> {
    // mapIndexed의 인자 transform이 index(Int)와 generic T를 인자로 받아 R을 리턴한다.
}