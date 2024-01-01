package chapter3.Overloading

import appendix.atomictest.eq

class My {
    fun foo() = 0
}

// 같은 멤버함수가 있다면, 멤버 함수를 우선
fun My.foo() = 1

// 확장 함수를 이용하여 오버로딩 가능
fun My.foo(i: Int) = i + 2

fun main() {
    val my = My()
    my.foo() eq 0
    my.foo(11) eq 13
}