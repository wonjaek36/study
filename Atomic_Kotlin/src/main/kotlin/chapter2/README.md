# Chapter 2. Object

### Atom 16. 객체는 모든 곳에 존재한다

---

*Package: ObjectsEverywhere*


객체를 설명하기 위해서는, 클래스에 대해 알아야 한다.
* 클래스란 프로퍼티와 멤버 함수의 집합으로 엔지니어가 데이터 타입을 정의
* 프로퍼티는 클래스 내 변수로 클래스의 상태 값을 의미
* 멤버 함수는 클래스에 속한 함수
* 객체는 클래스 타입에 해당하는 값(val, var)를 선언하는 것. 인스턴스를 만든다고도 한다

### Atom 17. 클래스 만들기

---

*Package: CreatingClasses*

* 객체 생성과 멤버 함수 추가는 아래와 같이 한다.
```kotlin
class ClassName {
    fun member_function() = "I'm member function"
}

fun main() {
    val instance = ClassName()
    println(instance.member_function())
}
```
* "this" keyword를 통해서 객체 자신에게 접근 할 수 있다.
  * Python self와 비슷, 그렇지만 Kotlin에서는 함수 파라미터에 this를 넣지 않음


### Atom 18. 프로퍼티

---

*Package: Properties*

* 프로퍼티는 클래스의 변수로 클래스 상태를 의미한다고 볼 수 있다.
```kotlin
// percentFull 프로퍼티는 Cup 인스턴스의 상태를 의미
class Cup {
    var percentFull = 0
}

fun main() {
    val c = Cup()
    c.percentFull = 50 // Cup 인스턴스인 c의 상태 변환
}
```


### Atom 19. 생성자

*Package: Constructors*

* 생성자에 정보를 제공해 객체를 초기화(프로퍼티 초기값)할 수 있다.
* 이번 Atom에서는 기본 생성자만 이용
```kotlin
// 대표적인 예, 기본 생성자를 이용하여 객체 초기화
class ExampleClass(
    val name: String,
    val age: Int,
    val phone: String
) {
    fun describe() = 
        "I'm $name, I'm $age years old. " +
            "My phone number is $phone"
}

fun main() {
    val wjkim = ExampleClass("Wonjae Kim", 3, "01099998888")
}
```