package chapter2.summary

import appendix.atomictest.eq

class Badger(id: String, years: Int) {

    val name = id
    val age = years
    override fun toString(): String {
        return "Badger: $name, age: $age"
    }
}

class Snake (
    var type: String,
    var length: Double
) {
    override fun toString(): String {
        return "Snake: $type, length: $length"
    }
}

class Moose(
    val age: Int,
    val height: Double
) {
    override fun toString(): String {
        return "Moose: age: $age, height: $height"
    }
}

fun main() {
    Badger("Bob", 11) eq "Badger: Bob, age: 11"
    Snake("Garden", 1.5) eq "Snake: Garden, length: 1.5"
    Moose(5, 6.5) eq "Moose: age: 5, height: 6.5"
}