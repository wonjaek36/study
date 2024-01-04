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