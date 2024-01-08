package chapter3.Enumerations

import appendix.atomictest.eq
import chapter3.Enumerations.Direction.*

enum class Direction(val notation: String) {
    North("N"), South("S"),
    East("E"), West("W");
    val opposite: Direction
        get() = when(this) {
            North -> South
            South -> North
            East -> West
            West -> East
        }
}

fun main() {
    North.notation eq "N"
    North.opposite eq South
    West.opposite.opposite eq West
    North.opposite.notation eq "S"
}