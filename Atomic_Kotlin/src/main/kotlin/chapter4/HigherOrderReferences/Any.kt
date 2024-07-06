package chapter4.HigherOrderReferences

import appendix.atomictest.eq

fun <T> List<T>.any(
    predicate: (T) -> Boolean
): Boolean {
    for (element in this) {
        if (predicate(element))
            return true
    }
    return false
}

fun main() {
    val ints = listOf(1, 2, -3)
    // 우리가 정의한 Line 5번의 any 호출
    ints.any { it > 0 } eq true

    val strings = listOf("abc", " ")
    strings.any { it.isBlank() } eq true
    strings.any (String::isNotBlank) eq true
}