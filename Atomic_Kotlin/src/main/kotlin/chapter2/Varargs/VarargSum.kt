package chapter2.Varargs
import appendix.atomictest.eq

// vararg는 최대 하나만 선언할 수 있다.
fun sum(vararg numbers: Int): Int {
    var total = 0
    for (n in numbers) { // Vararg는 Array로 다뤄짐 (Array != List)
        total += n
    }
    return total
}

fun main() {
    sum(13, 27, 44) eq 84
    sum(1, 3, 5, 7, 9, 11) eq 36
    sum() eq 0
}