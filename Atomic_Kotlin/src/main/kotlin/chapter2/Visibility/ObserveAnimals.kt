package chapter2.Visibility

fun main() {

    // index++  // Error: Cannot access 'index': it is private in file
    // 일반적으로 이렇게 사용되지는 않음
    recordAnimals()
    recordAnimalsCount()
}