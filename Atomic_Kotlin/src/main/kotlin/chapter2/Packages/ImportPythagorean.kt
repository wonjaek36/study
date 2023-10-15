package chapter2.Packages

import chapter2.Packages.pythagorean.RightTriangle

fun main() {

    val rt = RightTriangle(3.0, 4.0)
    println(rt.hypotenuse())  // 5.0
    println(rt.area())  // 6.0
}
