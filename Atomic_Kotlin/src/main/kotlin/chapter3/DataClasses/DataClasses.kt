package chapter3.DataClasses

import appendix.atomictest.*

class Person(val name: String)

data class Contact(
    val name: String,
    val number: String
)

fun main() {
    // 아래 둘은 다르다고 정의됨
    Person("Cleo") neq Person("Cleo")
    // 데이터 클래스는 타당한 동등성 검사를 제공함
    Contact("Miffy", "1-234-567890") eq Contact("Miffy", "1-234-567890")
}