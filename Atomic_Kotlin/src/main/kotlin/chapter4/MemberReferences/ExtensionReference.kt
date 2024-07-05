package chapter4.MemberReferences

import appendix.atomictest.eq

// Extension function
fun Int.times47() = times(47) // Return Value * 47

class Frog
fun Frog.speak() = "Rabbit!"

// goInt 는 고차함수 / g 가 함수를 인자로 받음
fun goInt(n: Int, g: (Int) -> Int) = g(n)

fun goFrog(frog: Frog, g: (Frog) -> String) = g(frog)

fun main() {
    // Member 함수(Extension) Reference
    goInt(12, Int::times47) eq 564

    goFrog(Frog(), Frog::speak) eq "Rabbit!"
}
