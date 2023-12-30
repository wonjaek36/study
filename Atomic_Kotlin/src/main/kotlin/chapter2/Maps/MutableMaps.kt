package chapter2.Maps

import appendix.atomictest.eq

fun main() {
    val m = mutableMapOf(5 to "five", 6 to "six")
    m[5] eq "five"
    m[5] = "5ive"
    m[5] eq "5ive" // mutable

    m += 4 to "four"
    m eq mapOf(5 to "5ive", 6 to "six", 4 to "four")
}