package chapter2.Visibility

class Cookie(
    private var isReady: Boolean
) {
    private fun crumble() =
        println("crumble")

    public fun bite() =
        println("bite")

    fun eat() {
        isReady = true
        crumble()
        bite()
    }
}

fun main() {
    val x = Cookie(false)
    x.bite()  // bite
    // x.isReady  // Error: Cannot access 'isReady': it is private in 'Cookie'
    // x.crumble()  // Error: Cannot access 'crumble': it is private in 'Cookie'
    x.eat()  // crumble \n bite
}