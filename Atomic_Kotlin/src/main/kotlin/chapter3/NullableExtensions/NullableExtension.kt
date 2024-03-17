package chapter3.NullableExtensions
import appendix.atomictest.eq

fun String?.isNullOrEmpty(): Boolean =
    this == null || this.isEmpty()

fun main() {
    "".isNullOrEmpty() eq true
}