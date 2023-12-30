package chapter2.PropertyAccessors

import appendix.atomictest.eq

class Hamster(val name: String)

class Cage(private val maxCapacity: Int) {
    private val hamsters = mutableListOf<Hamster>()

    val capacity: Int
        get() = maxCapacity - hamsters.size
    /*
    // property가 아닌 함수로 구현해도 무방
    fun capacity(): Int = maxCapacity - hamsters.size
     */

    val full: Boolean
        get() = hamsters.size == maxCapacity

    fun put(hamster: Hamster): Boolean =
        if (full) false
        else {
            hamsters += hamster
            true
        }

    fun take(): Hamster = hamsters.removeAt(0)
}

fun main() {
    val cage = Cage(2)
    cage.full eq false
    cage.capacity eq 2
    cage.put(Hamster("Alice")) eq true
    cage.put(Hamster("Bob")) eq true
    cage.full eq true
    cage.capacity eq 0
    cage.put(Hamster("Charlie")) eq false
    cage.take().name eq "Alice"
    cage.capacity eq 1
}