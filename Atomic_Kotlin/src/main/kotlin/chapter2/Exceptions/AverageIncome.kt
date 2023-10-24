package chapter2.Exceptions

import appendix.atomictest.*

fun averageIncome(income: Int, months: Int) = income / months

fun main() {
    averageIncome(3300, 3) eq 1100
    capture {
        averageIncome(5000, 0)
    } eq "ArithmeticException: 0으로 나누기"
}

