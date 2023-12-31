package chapter2.summary

import appendix.atomictest.eq

class Holder(var i: Int)

fun main() {
    val holder = Holder(10)
    holder.i eq 10
    holder.i = 20
}