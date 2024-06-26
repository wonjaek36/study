package chapter4.OperationsOnCollections

import appendix.atomictest.eq

fun main() {
    val list = listOf(1, 2, null)
    list.filterNotNull() eq "[1, 2]"
}