package chapter2.Lists

import appendix.atomictest.eq

fun main() {
    val doubles = listOf(1.1, 2.2, 3.3, 4.4)
    doubles.sum() eq 11.0

    val strings = listOf("Taws", "Brillig", "And", "Slithy", "Toves")
    strings eq listOf("Taws", "Brillig", "And", "Slithy", "Toves")
    strings.sorted() eq listOf("And", "Brillig", "Slithy", "Taws", "Toves")
    strings.first() eq "Taws"
    strings.takeLast(2) eq listOf("Slithy", "Toves")
}