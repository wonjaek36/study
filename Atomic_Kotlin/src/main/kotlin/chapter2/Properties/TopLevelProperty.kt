package chapter2.Properties

val constant = 42

var counter = 0  // (anti-pattern)
// 프로그램이 복잡해지면, 공유된 가변 변수를 추론하기 어려움.

fun inc() {
    counter ++
}