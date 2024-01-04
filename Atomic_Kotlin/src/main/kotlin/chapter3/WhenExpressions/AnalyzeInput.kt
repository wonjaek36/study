package chapter3.WhenExpressions

import appendix.atomictest.*

class Coordinates {
    var x: Int = 0
        set(value) {
            trace("x gets $value")
            field = value
        }
    var y: Int = 0
        set(value) {
            trace("y gets $value")
            field = value
        }

    override fun toString() = "($x, $y)"
}

fun processInput(inputs: List<String>) {
    val coordinates = Coordinates()
    for (input in inputs) {
        when (input) {
            "up", "u" -> coordinates.y--
            "down", "d" -> coordinates.y++
            "left", "l" -> coordinates.x--
            "right", "r" -> {
                trace("Moving right")
                coordinates.x++
            }
            "nowhere" -> {}
            "exit" -> return
            else -> trace("bad input: $input")
        }
    }
}

fun main() {
    processInput(listOf("up", "d", "nowhere", "left", "right", "exit", "r"))
    trace eq """
        y gets -1
        y gets 0
        x gets -1
        Moving right
        x gets 0
    """.trimIndent()
}