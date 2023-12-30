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

---

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

### Atom 20. 가시성 제한하기

---

*Package: Visibility*

* Java와 비슷하게 접근 변경자로 함수 또는 변수들의 가시성을 통제한다.
  * public, private, protected, internal
* Class 내에 private이 붙은 변수/함수는 같은 class에 속한 멤버들만 접근 가능
* private이 붙은 클래스 그리고 최상위 함수와 프로퍼티는 해당 파일 내에서만 접근 가능

```kotlin
// Visibility/RecordAnimal.kt 일부

private var index = 0

private class Animal(val name: String)

private fun recordAnimal(
    animal: Animal
) {
    println("Animal #$index: ${animal.name}")
    index ++
    // 파일 내 private 최상위 변수/함수에 접근 가능
}
```

### Atom 21. 패키지

---

*Package: Packages*

* 프로그램을 구현할 때, 코드를 여러 번 반복하지 않는 것이 좋다. (**DRY 원칙**)
* Java와 같이 Kotlin에서도 패키지를 제공하여 연관있는 코드를 묶어 놓는다
* 내가 생성한 클래스를 가져다 사용하기 위해서는
  * 같은 패키지 내라면, 그대로 사용
  * 다른 패키지라면, 일반적으로 import 하고 사용한다.

```Kotlin
// ImportPythagorean.kt 일부

import pythagorean.RightTriangle

fun main() {
    val rt = RightTriangle(3.0, 4.0)
    // 생략...
} 
```

### Atom 22. 테스트

---

*Package: Testing*

* 코드를 수정할 때, 안전하게 수정하기 위해 테스트를 이용한다.
* println을 이용한 부실한 방법이 아니라 JUnit, Kotest, Spek 등을 이용하면 안전하게 자동화할 수 있다.
* 테스트 주도 개발법 (TDD) 참고

참고: **infix** 키워드는 함수 작성을 후위순회 방식에서 중위순회로 변환해준다.

즉, 함수(A, B)을 A 함수 B로 작성할 수 있게 해준다.
```kotlin
// appendix.atomictest eq 함수
infix fun <T> T.eq(rval: T) {
  test(this, rval) {
    this == rval
  }
}

fun main() {
    val v1 = 47
    v1 eq 47  // Test passed
}
```


### Atom 23. 예외

---

*Package: Exceptions*

* Divide by Zero 등 상황에 따라 발생하는 에러를 처리하기 위해 이용
* 발생하는 Exception을 통해 왜 에러가 발생했는지 알 수 있으며, 개발자가 메세지를 남겨 더 자세한 상황을 공유할 수 있음
* Kotlin에서는 자바와 똑같이 try / catch 문을 이용
  * 책에서는 appendix A에서 정의한 capture 이용

```kotlin
// Kotlin try / catch 
try {
    val i = 10 / 0 // Causing divide by zero
} catch (e: ArithmeticException) {
    // handling exception
}
```

### Atom 24. 리스트

---

*Package: Lists*

* 불변 리스트와 가변 리스트(Mutable List) 타입이 있다.
  * 불변 리스트는 listOf<Type>으로 생성 (일반적으로 Type은 생략)
  * 가변 리스트는 mutableListOf<Type>으로 생성
* 불변 리스트 타입은 일반적으로 값을 넣거나 뺄 수 없다.
  * 가변 변수에 정의했을 경우 연산자가 동작하는 것처럼 보일 수 있지만, 리스트는 불변이다. (아래 코드에서 확인)

```kotlin
// 불변 리스트
val ints = listOf(1, 2, 3)
// ints += 4  val cannot be reassigned

// 가변 리스트
val mutableInts = mutableListOf<Int>(1, 2, 3)
mutableInts += 4
mutableInts.add(5)

// Lists/PlusAssignPuzzle.kt 참고
var mutableVars = listOf(1, 2, 3)
mutableVars += 4  // [1, 2, 3, 4]
// 아래와 같은 코드
val tmpList = mutableVars + 4
mutableVars = tmpList
```

### Atom 25. 가변 인자 목록

---

*Package: Varargs*

* 함수에 vararg 키워드를 이용하면 임의의 개수로 인자를 받을 수 있다.
* 다만, 선언된 인자가 하나만 있어 한 타입의 인자만 0~N개 를 받을 수 있다.
* 타입은 Array로 취급되고 스프레드 연산자 (*) 를 이용하면 원소로 다른 함수에 넘길 수도 있다.

```kotlin
// 가변 인자 VarargSum.kt 중 일부
fun sum(vararg numbers: Int): Int {
    var total = 0
    for (n in numbers) {
        total += n
    }
    return total
}

// Spread 연산자 이용하여 가변 인자 전달
fun first(vararg numbers: Int) {
    sum(*numbers)
}
```

### Atom 26. 집합(Set)

---
*Package: Sets*
- Set 연산을 이용하여 수학의 집합을 구현할 수 있다.
- Set은 중복을 허용하지 않고, 원소 추가, 검색 삭제가 가능하다.
- 그리고 집합끼리읜 합(union), 교(intersection), 차(difference) 연산이 가능하다.
- 실무적으로는 리스트의 원소 중복을 제거 하기 위해 많이 이용 (또는 리스트의 distinct 이용)
```kotlin
val intSet = setOf(1, 1, 2, 3, 9, 9, 4)
// 중복 없음
intSet eq setOf(1, 2, 3, 9, 4)

// 순서 중요하지 않음
setOf(1, 2) eq setOf(2, 1)

// 원소 검사
(9 in intSet) eq true
(99 in intSet) eq false

intSet.contains(9) eq true
intSet.contains(99) eq false

// 다른 집합 포함 여부
intSet.containsAll(setOf(1, 9, 2)) eq true

// 합 집합
intSet.union(setOf(3, 4, 5, 6)) eq setOf(1, 2, 3, 4, 5, 6, 9)

// 교 집합
intSet.intersect(setOf(0, 1, 2, 7, 8)) eq setOf(1, 2)

// 차 집합
intSet subtract setOf(0, 1, 9, 10) eq setOf(2, 3, 4)
intSet - setOf(0, 1, 9, 10) eq setOf(2, 3, 4)
intSet.subtract(setOf(0, 1, 9, 10)) eq setOf(2, 3, 4)
```

### Atom 27. 맵(Map)

---

*Package: Maps*

- 키와 값을 연결하고, 키를 이용하여 값을 찾을 수 있다.
- List, Set과 마찬가지로 immutable, mutable한 맵이 분리되어있다
- 키와 값의 타입은 제한이 없어, 일반 클래스도 이용할 수 있다.
```kotlin
val constants = mapOf(
  "Pi" to 3.141,
  "e" to 2.718,
  "phi" to 1.618
)

constants eq "{Pi=3.141, e=2.718, phi=1.618}"

// 키에 맞는 값을 찾는다
constants["e"] eq 2.718
constants.keys eq setOf("Pi", "e", "phi")
constants.values.toSet() eq setOf(3.141, 2.718, 1.618)

// Contact 객체를 Map Value에 저장
val miffy = Contact("Miffy", "1-234-567890")
val cleo = Contact("Cleo", "098-765-4321")
val contacts = mapOf(
  miffy.phone to miffy,
  cleo.phone to cleo)

contacts["1-234-567890"] eq Contact("Miffy", "1-234-567890")
contacts["098-765-4321"] eq Contact("Cleo", "098-765-4321")
```