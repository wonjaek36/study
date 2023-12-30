package chapter2.summary

import appendix.atomictest.eq

class Temperature {
    var current = 0.0
    var scale = "f"
    fun setFarenheit(now: Double) {
        current = now
        scale = "f"
    }

    fun setCelsius(now: Double) {
        current = now
        scale = "c"
    }

    fun getFarenheit(): Double {
        return if (scale == "f") current else current * 9.0 / 5.0 + 32.0
    }

    fun getCelsius(): Double {
        return if (scale == "c") current else (current - 32.0) * 5.0 / 9.0
    }
}

fun main() {
    val temp = Temperature()
    temp.setFarenheit(98.6)
    temp.getFarenheit() eq 98.6
    temp.getCelsius() eq 37.0
    temp.setCelsius(100.0)
    temp.getFarenheit() eq 212.0
    temp.getCelsius() eq 100.0
}