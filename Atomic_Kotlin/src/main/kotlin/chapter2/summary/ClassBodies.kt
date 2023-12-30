package chapter2.summary

class NoBody

class SomeBody {
    val name: String = "SomeBody"
}

class EveryBody {
    val all = listOf(SomeBody(), SomeBody(), SomeBody())
}

fun main() {
    val noBody = NoBody()
    val someBody = SomeBody()
    val everyBody = EveryBody()
}