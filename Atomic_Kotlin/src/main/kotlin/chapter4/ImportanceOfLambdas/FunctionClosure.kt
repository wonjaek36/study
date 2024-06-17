package chapter4.ImportanceOfLambdas

import appendix.atomictest.eq

var x = 100

fun useX() {
    // global x is captured
    x++
}

fun main() {
    useX()
    x eq 101
}