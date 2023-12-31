package chapter2.summary

import appendix.atomictest.capture

fun main() {
    capture {
        "$1.9".toDouble()
    } eq "NumberFormatException: For input string: \"$1.9\""
}