package chapter3.IntroGenerics

import appendix.atomictest.eq

fun <T> List<T>.first(): T {
    if (isEmpty())
        throw NoSuchElementException("List is empty.")
    return this[0]
}

fun <T> List<T>.firstOrNull(): T? = if (isEmpty()) null else this[0]

fun main() {
    listOf(1, 2, 3).first() eq 1
    val i: Int? = listOf(1, 2, 3).firstOrNull()
    i eq 1
    val s: String? = listOf<String>().firstOrNull()
    s eq null
}
