package chapter2.Exceptions

import appendix.atomictest.*

fun main() {
    capture {
        "1$".toInt()
    } eq "NumberFormatException: " +
            """For input string: "1$""""
}