package chapter3.Overloading

import appendix.atomictest.eq
fun f2(n: Int = 0) = n + 373

fun main() {
    f2() eq 373
    f2(11) eq 384
}