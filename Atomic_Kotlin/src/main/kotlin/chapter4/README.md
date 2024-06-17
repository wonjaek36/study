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