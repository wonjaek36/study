package chapter3.Overloading

import appendix.atomictest.eq

class Overloading {
    // 함수의 시그니처는 함수 이름, 파라미터 목록, 반환 타입으로 구성
    fun f() = 0
    fun f(n: Int) = n + 2
}

fun main() {
    val o = Overloading()
    o.f() eq 0
    o.f(11) eq 13
}