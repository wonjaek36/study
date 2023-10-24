package chapter2.Exceptions


fun erroneousCode() {
    // Cause Exception
    val i = "1$".toInt() // java.lang.NumberFormatException
}

fun main() {
    erroneousCode()
}