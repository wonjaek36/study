package chapter3.NullableTypes

class Amphibian

enum class Species {
    Frog, Toad, Salamander, Caecilian
}

fun main() {
    val a1: Amphibian = Amphibian()
    // 클래스의 인스턴스도 Nullable 될 수 있다.
    val a2: Amphibian? = null
    val at1: Species = Species.Toad
    // 열거형도 마찬가지
    val at2: Species? = null
}