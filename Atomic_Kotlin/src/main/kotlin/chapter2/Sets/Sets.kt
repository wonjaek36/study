package chapter2.Sets

import appendix.atomictest.eq

fun main() {
    val intSet = setOf(1, 1, 2, 3, 9, 9, 4)
    // 중복 없음
    intSet eq setOf(1, 2, 3, 9, 4)

    // 순서 중요하지 않음
    setOf(1, 2) eq setOf(2, 1)

    // 원소 검사
    (9 in intSet) eq true
    (99 in intSet) eq false

    intSet.contains(9) eq true
    intSet.contains(99) eq false

    // 다른 집합 포함 여부
    intSet.containsAll(setOf(1, 9, 2)) eq true

    // 합 집합
    intSet.union(setOf(3, 4, 5, 6)) eq setOf(1, 2, 3, 4, 5, 6, 9)

    // 교 집합
    intSet.intersect(setOf(0, 1, 2, 7, 8)) eq setOf(1, 2)

    // 차 집합
    intSet subtract setOf(0, 1, 9, 10) eq setOf(2, 3, 4)
    intSet - setOf(0, 1, 9, 10) eq setOf(2, 3, 4)
    intSet.subtract(setOf(0, 1, 9, 10)) eq setOf(2, 3, 4)
}