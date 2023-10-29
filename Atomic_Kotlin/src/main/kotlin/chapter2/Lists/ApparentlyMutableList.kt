package chapter2.Lists

import appendix.atomictest.eq

fun main() {
    var list = listOf('X')
    list += 'Y'
    list eq "[X, Y]"
}