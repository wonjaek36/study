package chapter3.NamedAndDefaultArgs

import appendix.atomictest.eq

class Color3 (
    val red: Int = 0,
    val green: Int = 0,
    val blue: Int = 0
) {
    override fun toString() = "($red, $green, $blue)"
}

fun main() {
    Color3(red = 77).toString() eq "(77, 0, 0)"
}