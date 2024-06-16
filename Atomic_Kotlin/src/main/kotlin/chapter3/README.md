# Chapter 3. 사용성

### Atom 30. 확장 함수(Extension Functions)

---

*Package: ExtensionFunctions*

- 클래스 외부에서 기존 클래스에 멤버 함수를 추가하는 기능
  - 클래스의 외부에서 private 변수/함수 접근은 불가능 (캡슐화 유지)
- 확장 대상 클래스를 수신 객체 타입(receiver type)이라고 부름
```kotlin
fun String.singleQuote(): String = "'$this'"
fun String.doubleQuote(): String = "\"$this\""

fun main() {
    "Hi".singleQuote() eq "'Hi'"
    "Hi".doubleQuote() eq "\"Hi\""
}
```

### Atom 31. 이름 붙은 인자와 디폴트 인자

---

- 함수 호출 시 인자의 이름을 명시하여 값을 전달할 수 있다.
  - 인자의 이름을 명시하면, 인자 순서와 관계 없이 전달 가능하다
  - 기본 값이 있다면, 인자의 일부만 명시할 수도 있다.
- 잘 활용하면, 가독성이 좋은 코드를 작성할 수 있다.
- Java 와 비슷

```kotlin
/*** Color2 ***/
fun color2(
    red: Int = 0,
    green: Int = 0,
    blue: Int = 0
) = "($red, $green, $blue)"

fun main() {
    // green, blue은 기본 값 활용
    color2(139) eq "(139, 0, 0)"
    // blue만 이름 명시
    color2(blue = 139) eq "(0, 0, 139)"
    color2(255, 165) eq "(255, 165, 0)"
    color2(red = 128, blue = 128) eq "(128, 0, 128)"
}

/*** CreateString2 ***/
// separator와 postfix를 명시하여 가독성 개선
val list = listOf(1, 2, 3)
list.joinToString(". ", "", "!") eq "1. 2. 3!"
list.joinToString(separator = ". ", postfix = "!") eq "1. 2. 3!"
```


### Atom 32. 오버로딩(Overloading)

---

*Package: Overloading*

- 파라미터 목록이 다른 여러 함수에 같은 이름을 사용하는 것을 "오버로딩"이라 함
  - 함수의 시그니처는 함수 이름, 파라미터 목록, 반환 타입으로 구성
  - 코틀린은 함수 시그니처를 이용하여 구분하기 때문에, 파라미터 목록이 다르면 다른 함수로 인식한다.
- 오버로딩을 이용하면, 의미적으로 같은 작업을 다른 타입에 대해 같은 이름으로 정의할 수 있다.
  - OverloadingAdd.kt 참고
  
```kotlin
/*** Overloading ***/
class Overloading {
  // 함수의 시그니처는 함수 이름, 파라미터 목록, 반환 타입으로 구성
  fun f() = 0
  fun f(n: Int) = n + 2
}

/*** Overloading Add ***/
fun addInt(i: Int, j: Int) = i + j
fun addDouble(i: Double, j: Double) = i + j

// 다른 타입에 대해 같은 이름으로 함수 정의
fun add(i: Int, j: Int) = i + j
fun add(i: Double, j: Double) = i + j

fun main() {
  addInt(5, 6) eq add(5, 6)
  addDouble(56.23, 44.77) eq add(56.23, 44.77)
}
```

### Atom 33. When 식

---

*Package: WhenExpressions*

- When을 이용하면 if문을 더 아름답게 작성할 수 있다.
- When 괄호 안에 비교를 하고 싶은 값을 작성하고, 각 조건에 대해 실행할 코드를 작성한다.
- When은 값이 가질 수 있는 모든 값에 대해서 실행할 코드가 필요하다.
  - 그렇지 않을 경우, when expression must be exhaustive 에러가 발생한다

```kotlin
// If와 When 구문 비교
// Part of BmiWhen.kt
fun bmiMetricOld(
  kg: Double,
  heightM: Double
): String {
  val bmi = kg / (heightM * heightM)
  return if (bmi < 18.5) "Underweight"
  else if (bmi < 25) "Normal weight"
  else "Overweight"
}

fun bmiMetricWithWhen(
  kg: Double,
  heightM: Double
): String {
  val bmi = kg / (heightM * heightM)
  return when {
    bmi < 18.5 -> "Underweight"
    bmi < 25 -> "Normal weight"
    else -> "Overweight"
  }
}
```

### Atom 34. 이넘(Enum)

---

*Package: Enumerations*

- Enum은 이름을 모아둔 것
- Enum 클래스가 정의된 파일에서 enum 값을 임포트하여 사용할 수도 있다.
- 일반 클래스와 동일하게, 멤버 함수와 멤버 프로퍼티를 정의할 수 있다.
```kotlin
//RecursiveEnumImport 일부
import chapter3.Enumerations.Size.*

enum class Size {
  Tiny, Small, Medium, Large, Huge, Gigantic
}

// Direction
// Enum 안에 멤버 함수 정의
enum class Direction(val notation: String) {
  North("N"), South("S"),
  East("E"), West("W");
  val opposite: Direction
    get() = when(this) {
      North -> South
      South -> North
      East -> West
      West -> East
    }
}
```

### Atom 35. 데이터 클래스(Data Classes)

---

*Package: DataClasses*

- 데이터 클래스를 이용하면 Boilerplate code를 줄일 수 있다.
  - toString(), equals(), hashCode(), copy() 등
  - equals()는 모든 프로퍼티를 비교하여 같은지 확인
  - copy()를 이용하면 객체를 복사하고, 일부 프로퍼티를 변경할 수 있다.
  - HashMap, HashSet을 이용하면, hashCode와 equals를 이용해 빠르게 데이터 클래스 객체를 검색

```kotlin
// Simple.kt 중 일부 / 자동 생성된 ToString
data class Simple(
  val arg1: String,
  val arg2: Int
)

fun main() {
  val s1 = Simple("Hi", 29)
  val s2 = Simple("Hi", 29)
  s1 eq "Simple(arg1=Hi, arg2=29)"
  s1 eq s2
}

// CopyDataClass.kt 중 일부 / copy()를 이용한 객체 복사
val contact = DetailedContact(
  "Miffy",
  "Miller",
  "1-234-567890",
  "1600 Amphitheatre Parkway")
val newContact = contact.copy(
  number = "098-765-4321",
  address = "Brandschenkestrasse 110")

// HashCode.kt 중 일부 / hashCode()를 이용한 검색

data class Key(
  val name: String,
  val id: Int
)

fun main() {
  val korvo: Key = Key("Korvo", 19)
  korvo.hashCode() eq -2041757108
  val map =  HashMap<Key, String>()
  map[korvo] = "Alien"
}
```

### Atom 36. 구조 분해 (Destructuring)

---

*Package: Destructuring*

- Pair, Tuple 클래스의 값을 구조 분해를 통해 변수에 편하게 대입할 수 있다.
- 데이터 클래스의 프로퍼티에도 구조 분해를 적용할 수 있다.

```kotlin
// PairDestructuring.kt 중 일부
fun compute(input: Int): Pair<Int, String> =
  if (input > 5)
    Pair(input * 2, "High")
  else
    Pair(input * 2, "Low")

val (value, description) = compute(7)
value eq 14
description eq "High"

// ComputeDestructuring.kt 중 일부 / 데이터 클래스도 구조 분해가 가능하다
data class Computation(
  val data: Int,
  val info: String
)

fun evaluate(input: Int) =
  if (input > 5)
    Computation(input * 2, "High")
  else
    Computation(input * 2, "Low")

fun main() {
  val (value, description) = evaluate(7)
```

### Atom 37. 널이 될 수 있는 타입 (Nullable)

---

*Package: NullableTypes*

- 코틀린에서 기본적으로 타입 또는 클래스에서 널을 허용하지 않는다.
  - 예) Int, Double, ... 등
- 어떤 작업의 결과가 Null을 반환할 수 있다면, 타입에 ?를 붙여 널이 될 수 있는 타입으로 변경한다.
  - 예) Int? Double? 
- Null을 허용하지 않는 타입의 값은 Nullable 타입의 값으로 대입할 수 있다.
  - 그 반대는 허용되지 않는다.

```kotlin
// NullableTypes.kt 중 일부
val s1 = "abc"

// 컴파일 오류
// val s2: String = null

val s3: String? = null
val s4: String? = s1

// 컴파일 오류
// val s5: String = s4
// s5: String / s4: String?  Type
val s6 = s4

s1 eq "abc"
s3 eq null
s4 eq "abc"
s6 eq "abc"
```

### Atom. 38 안전한 호출과 엘비스 연산자 (Safe Calls and the Elvis Operator)

---

* Package: SafeCallsAndElvis

- 널이 될 수 있는 타입에 안전 호출(.?)을 이용하면 널이 아닐 때만 호출된다.
- 엘비스 연산자(?:)를 이용하면, 널일 때 기본 값을 사용하도록 할 수 있다.

```kotlin
val s: String? = null
println(s?.length ?: 0) // 0

val t: String? = "Hello"
println(t?.length ?: 0) // 5
```

### Atom 39. 널 아님 단언 (Non-null Assertion)

--- 

* Package: NonNullAssertion

- 널이 될 수 있는 타입이지만, 널이 아니란 걸 확신할 때 널 아님 단언(!!)을 사용
- !!을 사용하면 컴파일러는 값이 널이 아니라고 확신하고, 널이 아닌 타입으로 변환을 시도한다.
  - 그런데 값이 널이라면, NullPointerException이 발생한다.
- 자바와 상호작용하기 위해 도입하였지만, 자주 사용하는 것은 권장하지 않는다.
  - 안전한 호출과 엘비스 연산자를 권장

```kotlin
import atomictest.*

val s: String? = "abc"
s!!.length eq 3

capture {
  val s: String = x!!
} eq "NullPointerException"
```

### Atom 40. 확장 함수와 널이 될 수 있는 타입

---

* Package: NullableExtensions

- 널이 될 수 있는 타입에 확장 함수를 정의할 수 있다.
```kotlin
fun String?.isNullOrEmpty(): Boolean =
    this == null || this.isEmpty()

fun main() {
    "".isNullOrEmpty() eq true
}
```

### Atom 41. 제네릭스 소개

---

* Package: IntroGenerics

- 제너릭스는 타입을 파라미터화한다.
  - 제너릭스 함수는 여러 타입에 대해 동작할 수 있다.
- 클래스에서 사용할 때, 클래스 이름 뒤에 플레이스 홀더를 추가한다. ex) class GenericHolder<T>
- 함수에서 사용할 때는 함수 이름 앞에 플레이스 홀더를 추가한다. ex) fun <T> identity(arg: T): T

```kotlin
// 제너릭스 사용하는 클래스 정의
// GenericHolder.kt 중 일부
class GenericHolder<T>(
  private val value: T
) {
  fun getValue(): T = value
}

// 제너릭스 사용하는 함수 정의
// GenericFunction.kt 중 일부
fun <T> identity(arg: T): T = arg
```