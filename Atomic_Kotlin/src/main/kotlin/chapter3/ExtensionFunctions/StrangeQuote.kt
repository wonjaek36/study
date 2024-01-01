package chapter3.ExtensionFunctions

import appendix.atomictest.eq

fun String.strangeQuote(): String = this.singleQuote().singleQuote()
fun String.tooManyQuotes(): String = this.doubleQuote().doubleQuote()

fun main() {
    "Hi".strangeQuote() eq "''Hi''"
    "Hi".tooManyQuotes() eq "\"\"Hi\"\""
}