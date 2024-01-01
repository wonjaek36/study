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