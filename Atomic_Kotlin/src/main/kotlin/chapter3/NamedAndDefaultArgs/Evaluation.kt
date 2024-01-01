package chapter3.NamedAndDefaultArgs

class DefaultArg
val da = DefaultArg()

fun g(d: DefaultArg = da) = println(d)

fun h(d: DefaultArg = DefaultArg()) = println(d)

fun main() {
    g()
    g() // g()는 da(DefaultArg) 인스턴스를 재사용
    h()
    h() // h()는 DefaultArg() 인스턴스를 재생성
}