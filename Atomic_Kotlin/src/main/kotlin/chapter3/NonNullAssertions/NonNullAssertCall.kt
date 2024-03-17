package chapter3.NonNullAssertions

import appendix.atomictest.eq

fun main() {
    val s: String? = "abc"
    s!!.length eq 3
}