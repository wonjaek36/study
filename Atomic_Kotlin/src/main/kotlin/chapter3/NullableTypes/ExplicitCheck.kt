package chapter3.NullableTypes

fun main() {
    val s: String? = "abc"
    if (s != null) { // 명시적으로 null이 아닌지 체크
        println(s.length)
    }
}