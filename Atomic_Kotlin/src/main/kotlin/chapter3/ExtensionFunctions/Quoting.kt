package chapter3.ExtensionFunctions

import appendix.atomictest.eq

fun String.singleQuote(): String = "'$this'"
fun String.doubleQuote(): String = "\"$this\""

fun main() {
    "Hi".singleQuote() eq "'Hi'"
    "Hi".doubleQuote() eq "\"Hi\""
}