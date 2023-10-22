package chapter2.Testing

import appendix.atomictest.eq


fun main() {
    // 1, 3 테스트 실패 / 모든 bmi가 0으로 나옴 / 책 오류
    // calculateBMI2가 Int 형을 사용하기 때문에 원하는 결과가 나오지 않는다.
    // calculateBMI2(160, 68) eq "Normal weight"
    calculateBMI2(100, 68) eq "Underweight"
    // calculateBMI2(200, 68) eq "Overweight"
}

fun calculateBMI2(
    weight: Int,
    height: Int
): String {
    val bmi = weight / (height * height) * 703.07
    return if (bmi < 18.5) "Underweight"
        else if (bmi < 25) "Normal weight"
        else "Overweight"
}