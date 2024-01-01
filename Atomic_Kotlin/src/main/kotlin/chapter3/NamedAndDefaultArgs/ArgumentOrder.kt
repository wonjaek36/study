package chapter3.NamedAndDefaultArgs

import appendix.atomictest.eq

fun main() {
    color(blue = 0, red = 88, green = 52) eq
        "(88, 52, 0)"
    color(red=255, 255, 0) eq
        "(255, 255, 0)"
}