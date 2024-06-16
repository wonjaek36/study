package chapter3.ExtensionProperties

import appendix.atomictest.eq

fun main() {
    val list: List<*> = listOf(1, 2)
    // Star projection을 하면 List 내 타입 정보는 모두 잃어버린다.
    // 리스트 내 값을 Any? 타입에만 대입할 수 있다.
    val any: Any? = list[0]
    any eq 1
}