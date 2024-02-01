package chapter3.SafeCallsAndElvis

import appendix.atomictest.eq

fun checkLength(s: String?, expected: Int?) {
    // length1과 length2는 같은 코드
    val length1 = if (s != null) s.length else null
    val length2 = s?.length

    length1 eq expected
    length2 eq expected
}

fun main() {
    checkLength("abc", 3)
    checkLength(null, null)
}