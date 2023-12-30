package chapter2.PropertyAccessors

import appendix.atomictest.*

class LogChanges {
    var n: Int = 0
        set(value) {
            trace("n: $field becomes $value")
            field = value
        }

    var m: Int = 0
        set(value) {
            trace("m: $field becomes $value")
            field = value
        }
}

fun main() {
    val lc = LogChanges()
    lc.n = 1
    lc.n = 2
    lc.m = 3
    trace eq """
        n: 0 becomes 1
        n: 1 becomes 2
        m: 0 becomes 3
    """
}