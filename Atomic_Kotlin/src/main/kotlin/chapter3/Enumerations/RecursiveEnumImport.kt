package chapter3.Enumerations

import appendix.atomictest.eq
import chapter3.Enumerations.Size.*

enum class Size {
    Tiny, Small, Medium, Large, Huge, Gigantic
}

fun main() {
    Gigantic eq "Gigantic"
    // Kotlin version 1.9 recommend use entries, not values
    Size.entries eq listOf(Tiny, Small, Medium, Large, Huge, Gigantic)
    Tiny.ordinal eq 0
    Huge.ordinal eq 4
}