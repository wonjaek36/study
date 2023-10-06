package chapter2.Properties

class House {
    var sofa: String = ""
}

fun main() {
    val house = House()
    house.sofa = "Simple sleeper sofa: $89.00"
    println(house.sofa)
    house.sofa = "New leather sofa: $3,099.00"
    println(house.sofa)
    // house = House()  // Val cannot be reassigned
    // val 에 새 House를 대입할 수 없다.
    // 하지만 var 인 sofa에는 대입할 수 있다.
}