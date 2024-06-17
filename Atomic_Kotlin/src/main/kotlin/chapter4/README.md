# Chapter 4. 함수형 프로그래밍

### Atom 44. 람다

---

*Package: Lambdas*

- 람다 함수는 익명 함수라고도 하며, 함수 생성에 최소한의 조건만 요구한다.
  - 파라미터와 리턴 값
- 일반적으로, 함수를 한 번만 사용하거나 함수를 인자로 넘길 때 사용한다.

```kotlin
// 람다 사용
// BasicLambda.kt 중 일부 
val result = list.map( {n: Int -> "[$n]"} )

// Kotlin it 사용
// Lambdait.kt 중 일부
val result = list.map({ "$[it]" })

// 마지막 파라미터로 람다 함수를 넘길 때에는 괄호 밖에서 전달할 수 있다.
// JoinToString.kt 사용
list.joinToString(" ") { "[$it]" }
```

### Atom 45. 람다의 중요성

---

*Package: ImportanceOfLambdas*

- 람다는 반복을 피하면서 간결하게 코드를 작성할 수 있게 한다.
  - map, filter, reduce 등의 함수들은 리스트와 같은 컬렉션에서 iteration을 직접 처리해주어 많은 코드들을 생략할 수 있다.
  - 위와 같은 것이 함수형 프로그래밍의 특징
- 일반적으로, 람다에서는 클로저(Closure)가 빈번하게 발생한다.
  - 클로저란 자신이 속한 환경의 요소를 포획(Capture)하거나 닫는다(Close Up).
  - 하지만, 람다에서도 클로저가 없을 수 있고, 람다가 아닌 함수에서 클로저는 있을 수 있다.

```kotlin
// 람다 사용
// Filter.kt 중 일부
val even = list.filter { it % 2 == 0 }
val greaterThan2 = list.filter { it > 2 }

// Closure
// Closures2.kt 중 일부
var sum = 0
val divider = 5
list.filter { it % divider == 0 }
  .forEach { sum += it }
```