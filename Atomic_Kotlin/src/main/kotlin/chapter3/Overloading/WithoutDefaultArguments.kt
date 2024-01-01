package chapter3.Overloading

import appendix.atomictest.eq

fun f(n: Int) = n + 373
fun f() = f(0)


// 컴파일에는 문제가 없지만 권장하지 않는 코드
// default 값을 넣어주는게 좋다.
fun main() {
    f() eq 373
    f(11) eq 384
}