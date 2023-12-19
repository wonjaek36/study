package chapter2.Varargs

import appendix.atomictest.eq

fun main() {
    val array = intArrayOf(4, 5)
    // Spread 연산자(*)를 사용하면 flatten 되어 인자 목록으로 변환된다.
    sum(1, 2, 3, *array, 6) eq 21
    // 아래는 컴파일 되지 않는다.
    // sum(1, 2, 3, array, 6)

    val list = listOf(9, 10, 11)
    sum(*list.toIntArray()) eq 30
}