package chapter2.summary

import appendix.atomictest.eq

val colors =
    "Yellow Green Green Blue".split(Regex("""\W+""")).sorted()

fun main() {
    colors eq listOf("Blue", "Green", "Green", "Yellow")
    val colorSet = colors.toSet()
    colorSet eq setOf("Blue", "Green", "Yellow")
    (colorSet + colorSet) eq setOf("Blue", "Green", "Yellow")

    val mutableSet = colorSet.toMutableSet()
    mutableSet -= "Blue"
    mutableSet += "Red"
    mutableSet eq setOf("Green", "Yellow", "Red")
    ("Green" in colorSet) eq true
    colorSet.contains("Red") eq false
}