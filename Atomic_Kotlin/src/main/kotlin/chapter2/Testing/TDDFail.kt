package chapter2.Testing

import appendix.atomictest.eq

fun main() {
    calculateBMI(160, 68) eq "Normal weight"
    // calculateBMI(100, 68) eq "Underweight"
    // Error: Normal weight != Underweight
    // calculateBMI(200, 68) eq "Overweight"
    // Error: Normal weight != Overweight
}

fun calculateBMI(weight: Int, height: Int) = "Normal weight"