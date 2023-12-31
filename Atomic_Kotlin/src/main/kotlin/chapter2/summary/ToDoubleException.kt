package chapter2.summary

import appendix.atomictest.eq

fun main() {
    var i: Double?
    i = runCatching {
        "$1.9".toDouble()
    }.getOrNull()

    i eq null
}