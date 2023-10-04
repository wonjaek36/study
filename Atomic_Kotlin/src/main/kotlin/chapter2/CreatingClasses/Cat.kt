package chapter2.CreatingClasses

class Cat {
    fun meow() = "mrrow!"
}

fun main() {
    val cat = Cat()
    // 'cat'의 'meow()'를 호출
    val m1 = cat.meow()
    println(m1)  // mrrow!
}