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

---

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

---

### Atom 46. 컬렉션에 대한 연산

---

*Package: OperationsOnCollections*

- Collection 타입에 사용할 수 있는 연산들을 일부 소개
  - Collections 으로 List, Set, Map 등이 있다.
  - 특이하게도, map과 filter 등의 함수는 set 과 map 구조에 적용할 경우 결과값이 List로 반환된다.

```kotlin
// Create List with initialize lambda func
// CreatingList.kt / ListInit.kt 중 일부
val list = List(10) { 'a' + it } // ['a', 'b', 'c', ..., 'j']
val mutableList = MutableList(5) { 10 * (i + 1) } // [10, 20, ..., 50]

// filter or aggregate with lambda func
// Predicates.kt / Partitions.kt 일부
val list2 = listOf(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)
list2.filter { it > 5 } // [6, 7, 8, 9, 10]
list2.count { it > 5 } // 5
list2.find { it > 5 } // 6
list2.firstOrNull { it > 5 } // 6
list2.lastOrNull { it < 5 } // 4

// list2에 "it > 5"를 만족하는 값(it)이 하나라도 있으면 true 
list2.any { it > 5 } // true
// list2의 모든 원소가 "it > 5"를 만족한다면, true
list2.all { it > 5 } // false
// list2의 모든 원소가 "it < 0"를 만족한다면, true
list2.none { it < 0 } // true

val list3 = listOf(-3, -1, 5, 7, 10)
val (positive, negative) = list3.partition { it > 0 }
positive // [5, 7, 10]
negative // [-3, -1]

// sort or aggregate with lambda func
// ByOperations.kt 일부
data class Product(
    val description: String,
    val price: Double
)

val products = listOf(
    Product("bread", 2.0),
    Product("wine", 5.0)
)
// 가격 기중 내림차순 정렬
products.sortedByDescending { it.price }
// [Product(wine, 5.0), Product(bread, 2.0)]

// products의 가격 합계
products.sumOf { it.price } // 7.0

// products 중 가격이 가장 낮은 상품
products.minByOrNull { it.price } // 2.0

// Take or Drop
// TakeOrDrop.kt 일부
val list4 = listOf('a', 'b', 'c', 'D', 'E')
list4.take(3) // ['a', 'b', 'c']
list4.takeLastWhile { it.isUpperCase() } // ['D', 'E']
list4.drop(1) // ['b', 'c', 'D', 'E']
list4.dropWhile { it.isLowerCase() } // ['D', 'E'] 
```

---

### Atom 37. 멤버 참조

---

*Package: MemberReferences*

- 함수 인자로 멤버 참조(함수, 프로퍼티, 생성자)를 호출할 수 있다.

```kotlin
// Boolean 프로퍼티 사용
// PropertyReference.kt 일부
data class Message(
    val sender: String,
    val text: String,
    val isRead: Boolean
)

val unread = message.filterNot(Message::isRead)

// 함수 사용
// TopLevelFunctionRef.kt 일부
fun ignore(message: VerboseMessage) = 
    !message.isImportant() && message.sender in setOf("Boss", "Mom")

msgs.filter(::ignore)
msgs.filterNot(::ignore)
```