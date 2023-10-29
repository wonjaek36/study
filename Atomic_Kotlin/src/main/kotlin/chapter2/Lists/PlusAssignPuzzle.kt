package chapter2.Lists

import appendix.atomictest.eq

fun main() {
    //var/val에 가변 리스트 대입
    val list1 = mutableListOf('A')
    list1 += 'A' // 아래와 동일한 효과
    list1.plusAssign('A')

    //val에 불변 리스트 대입
    val list2 = listOf('B')
    // list2 += 'B'
    // list2 = list2 + 'B' // Error

    //var에 불변 리스트 대입
    var list3 = listOf('C')
    list3 += 'C' // 다음 두 줄과 같은 효과
    val tmpList = list3 + 'C'
    list3 = tmpList

    list1 eq "[A, A, A]"
    list2 eq "[B]"
    list3 eq "[C, C, C]"
}