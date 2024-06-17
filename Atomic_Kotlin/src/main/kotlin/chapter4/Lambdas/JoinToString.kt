package chapter4.Lambdas

import appendix.atomictest.eq

fun main() {
    val list = listOf(9, 11, 23, 32)
    list.joinToString(" ") { "[$it]" } eq "[9] [11] [23] [32]"
    // joinToString의 마지막 파라미터가 람다식(transform)
    // public fun <T> Iterable<T>.joinToString(
    //     separator: CharSequence = ", ",
    //     prefix: CharSequence = "",
    //     postfix: CharSequence = "",
    //     limit: Int = -1,
    //     truncated: CharSequence = "...",
    //     transform: ((T) -> CharSequence)? = null): String
}