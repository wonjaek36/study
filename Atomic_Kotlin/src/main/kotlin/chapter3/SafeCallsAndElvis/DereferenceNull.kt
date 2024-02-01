package chapter3.SafeCallsAndElvis

fun main() {
    val s: String? = null
    // 컴파일 오류
    // s.length -> s가 nullable이라서 length를 호출할 수 없다.
}