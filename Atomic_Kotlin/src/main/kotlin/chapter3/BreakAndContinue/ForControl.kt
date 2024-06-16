package chapter3.BreakAndContinue

import appendix.atomictest.eq

fun main() {
    val nums = mutableListOf(0)
    for (i in 4 ..< 100 step 4) {
        if (i == 8) continue
        if (i == 40) break
        nums.add(i)
    }

    nums eq "[0, 4, 12, 16, 20, 24, 28, 32, 36]"
}