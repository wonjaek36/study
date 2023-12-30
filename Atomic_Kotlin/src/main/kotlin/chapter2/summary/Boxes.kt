package chapter2.summary

import appendix.atomictest.*

private var count = 0

private class Box(val dimension: Int) {
    fun volume() =
        dimension * dimension * dimension
    override fun toString() =
        "Box volume: ${volume()}"
}

private fun countBox(box: Box) {
    trace("$box")
    count++
}

fun countBoxes() {
    countBox(Box(4))
    countBox(Box(5))
}

fun main() {
    countBoxes()
    trace eq """
        Box volume: 64
        Box volume: 125
    """
    count eq 2
}