package chapter2.Maps

import appendix.atomictest.eq
import chapter2.Properties.constant


class Contact(
    val name: String,
    val phone: String
) {
    override fun toString(): String {
        return "Contact($name, $phone)"
    }

    // eq 함수 적용을 위해 equals 함수를 오버라이드 한다.
    override fun equals(other: Any?): Boolean {
        if (other is Contact) {
            return name == other.name && phone == other.phone
        }
        return false
    }
}

fun main() {
    val miffy = Contact("Miffy", "1-234-567890")
    val cleo = Contact("Cleo", "098-765-4321")
    val contacts = mapOf(
        miffy.phone to miffy,
        cleo.phone to cleo)

    contacts["1-234-567890"] eq Contact("Miffy", "1-234-567890")
    contacts["098-765-4321"] eq Contact("Cleo", "098-765-4321")
}