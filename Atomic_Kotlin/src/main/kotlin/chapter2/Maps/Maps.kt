package chapter2.Maps

import appendix.atomictest.eq

fun main() {
    val constants = mapOf(
        "Pi" to 3.141,
        "e" to 2.718,
        "phi" to 1.618
    )

    constants eq "{Pi=3.141, e=2.718, phi=1.618}"

    // 키에 맞는 값을 찾는다
    constants["e"] eq 2.718
    constants.keys eq setOf("Pi", "e", "phi")
    // 타입은 맞춰 준다. (HashMap)
    constants.values.toSet() eq setOf(3.141, 2.718, 1.618)

    var s = ""
    // 키-값 쌍을 이터레이션 한다.
    for (entry in constants) {
        s += "${entry.key}=${entry.value},"
    }
    s eq "Pi=3.141,e=2.718,phi=1.618,"
}