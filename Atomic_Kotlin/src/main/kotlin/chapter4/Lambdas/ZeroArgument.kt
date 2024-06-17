package chapter4.Lambdas

import appendix.atomictest.trace

fun main() {
    run { -> trace("A Lambda") } // Not recommendedi
    run { trace("Without args") }
    trace eq """
        A Lambda
        Without args
    """
}