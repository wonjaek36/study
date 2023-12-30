package chapter2.PropertyAccessors

import appendix.atomictest.*

class Default {
    var i: Int = 0
        // Property i's getter and setter
        get() {
            trace("get()")
            return field
        }

        set(value) {
            trace("set($value)")
            field = value
        }
}

fun main() {
    val d = Default()
    d.i = 2
    trace(d.i)
    trace eq """
        set(2)
        get()
        2
    """
}