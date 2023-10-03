package chapter2.ObjectsEverywhere

fun fraction(numerator: Long, denom: Long) =
    numerator.toDouble() / denom

fun main() {
    val num = 1
    val den = 2
    val f = fraction(num.toLong(), den.toLong())
    // In Kotlin, type-casting should be done explicitly
    println(f)  // 0.5
}