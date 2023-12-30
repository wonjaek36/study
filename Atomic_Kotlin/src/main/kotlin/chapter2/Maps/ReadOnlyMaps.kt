package chapter2.Maps

import appendix.atomictest.eq

fun main() {
    val m = mapOf(5 to "five", 6 to "six")
    m[5] eq "five"
    // Below statements are not allowed
    // m[5] = "5ive"
    // m += 4 to "four"
    val n = m + (4 to "four")
    m eq mapOf(5 to "five", 6 to "six")
    n eq mapOf(5 to "five", 6 to "six", 4 to "four")
}