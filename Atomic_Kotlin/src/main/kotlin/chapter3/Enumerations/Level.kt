package chapter3.Enumerations

import appendix.atomictest.eq

enum class Level {
    Overflow, High, Medium, Low, Empty
}

fun main() {
    Level.Medium eq "Medium"
}