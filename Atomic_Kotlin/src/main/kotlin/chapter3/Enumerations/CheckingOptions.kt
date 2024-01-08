package chapter3.Enumerations

import appendix.atomictest.*
import chapter3.Enumerations.Level
import chapter3.Enumerations.Level.*

fun checkLevel(level: Level) {
    when (level) {
        Overflow -> trace(">>> Overflow")
        Empty -> trace("Alert: Empty")
        else -> trace("Level $level OK")
    }
}

fun main() {
    checkLevel(Overflow)
    checkLevel(Low)
    checkLevel(Empty)
    trace eq """
        >>> Overflow
        Level Low OK
        Alert: Empty
    """
}