package chapter2.summary

import appendix.atomictest.eq

fun main() {
    val first = mutableListOf(1)
    // second는 first와 같은 메모리 객체를 참조
    val second: List<Int> = first
    
    second eq listOf(1)
    first += 2
    second eq listOf(1, 2)
}