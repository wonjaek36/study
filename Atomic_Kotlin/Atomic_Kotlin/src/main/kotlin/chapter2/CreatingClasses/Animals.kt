package chapter2.CreatingClasses

class Giraffe
class Bear
class Hippo

fun main() {
    val g1 = Giraffe()
    val g2 = Giraffe()
    val b = Bear()
    val h = Hippo()

    // XXXXXXX는 메모리 위치
    println(g1)  // chapter2.CreatingClasses.Giraffe@XXXXXXX
    println(g2)  // chapter2.CreatingClasses.Giraffe@XXXXXXX
    println(b)  // chapter2.CreatingClasses.Bear@XXXXXXX
    println(h)  // chapter2.CreatingClasses.Hippo@XXXXXXX
}