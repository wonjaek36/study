package chapter2.Properties

class Cup {
    var percentFull = 0
}

fun main() {
    val c1 = Cup()
    c1.percentFull = 50
    val c2 = Cup()
    c2.percentFull = 100
    // var은 재대입이 가능하다.
    println(c1.percentFull)
    println(c2.percentFull)
}