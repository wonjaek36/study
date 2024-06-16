package chapter3.IntroGenerics

import appendix.atomictest.eq

class AnyHolder(private val value: Any) {
    fun getValue(): Any = value
}

class Dog {
    fun bark() = "Ruff!"
}

fun main() {
    val holder = AnyHolder(Dog())
    val any = holder.getValue()
    // Error: Unresolved reference: bark
    // 객체를 Any 타입으로 받아서 holder의 객체가 Dog인지 알 수 없다.
    // any.bark()

    val genericHolder = GenericHolder(Dog())
    val dog = genericHolder.getValue()
    dog.bark() eq "Ruff!"
}