package chapter2.PropertyAccessors

import appendix.atomictest.eq

class Counter {
    var value: Int = 0
        private set

    fun inc() = value++
}

fun main() {
    val counter = Counter()
    counter.inc()
    counter.value eq 1
    counter.inc()
    counter.value eq 2

    repeat(10) {
        counter.inc()
    }
    counter.value eq 12
}