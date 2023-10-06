package chapter2.Properties

class Sofa {
    val cover: String = "Loveseat cover"
}

fun main() {
    var sofa = Sofa()
    println(sofa)  // chapter2.Properties.Sofa@XXXXXXX
    // sofa.cover = "New cover" // val cannot be reassigned
    sofa = Sofa()
    println(sofa)  // chapter2.Properties.Sofa@XXXXXXX
}