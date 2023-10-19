package appendix.atomictest

import kotlin.math.abs
import kotlin.reflect.KClass

const val ERROR_TAG = "[Error]: "

private fun <L, R> test (
    actual: L,
    expected: R,
    checkEquals: Boolean = true,
    predicate: () -> Boolean
) {
    println(actual)
    if (!predicate()) {
        print(ERROR_TAG)
        println(
            "$actual " +
            (if (checkEquals) "!=" else "==") +
            " $expected")
    }
}

/**
 * this 객체의 문자열 표현을
 * rval 문자열과 비교한다.
 */
infix fun Any.eq(rval: String) {
    test(this, rval) {
        toString().trim() == rval.trimIndent()
    }
}

/**
 * this가 rval과 같은지 검증한다.
 */
infix fun <T> T.eq(rval: T) {
    test(this, rval) {
        this == rval
    }
}

