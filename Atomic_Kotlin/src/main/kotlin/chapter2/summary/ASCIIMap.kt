package chapter2.summary

import appendix.atomictest.*

fun main() {
    val ascii = mapOf(
        "A" to 65,
        "B" to 66,
        "C" to 67,
        "I" to 73,
        "J" to 74,
        "K" to 75
    )

    ascii eq "{A=65, B=66, C=67, I=73, J=74, K=75}"
    ascii["B"] eq 66
    ascii.keys eq "[A, B, C, I, J, K]"
    ascii.values eq "[65, 66, 67, 73, 74, 75]"

    var kv =""
    for (entry in ascii) {
        kv += "${entry.key}:${entry.value},"
    }
    kv eq "A:65,B:66,C:67,I:73,J:74,K:75,"
}