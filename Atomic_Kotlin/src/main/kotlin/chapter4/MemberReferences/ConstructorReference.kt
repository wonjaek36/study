package chapter4.MemberReferences

import appendix.atomictest.eq

data class Student(
    val id: Int,
    val name: String
)

fun main() {
    val names = listOf("Alice", "Bob")
    val students = names.mapIndexed {
        index, name -> Student(index, name)
    }
    students eq listOf(Student(0, "Alice"), Student(1, "Bob"))
    // Student 의 생성자를 사용 / index, name 을 순서대로 생성자에 전달
    names.mapIndexed(::Student) eq students
}