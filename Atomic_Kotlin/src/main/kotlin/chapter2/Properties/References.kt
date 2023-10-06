package chapter2.Properties

class Kitchen {
    var table: String = "Round table"
}

fun main() {
    val kitchen1 = Kitchen()
    val kitchen2 = kitchen1
    println("kitchen1: ${kitchen1.table}")  // Round table
    println("kitchen2: ${kitchen2.table}")  // Round table
    kitchen1.table = "Square table"
    println("kitchen1: ${kitchen1.table}")  // Square table
    println("kitchen2: ${kitchen2.table}")  // Square table

    println(kitchen1)  // chapter2.Properties.Kitchen@XXXXXX
    println(kitchen2)  // chapter2.Properties.Kitchen@XXXXXX  <- Same memory location
}