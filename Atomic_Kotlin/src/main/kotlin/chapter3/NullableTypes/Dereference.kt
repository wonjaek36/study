package chapter3.NullableTypes

import appendix.atomictest.eq

fun main() {
    val s1: String = "abc"
    val s2: String? = s1

    s1.length eq 3
    // 컴파일 오류 / s2는 nullable이므로 length를 호출할 수 없다.
    // s2.length eq 3
}