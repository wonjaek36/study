package chapter4.HigherOrderReferences

import appendix.atomictest.eq

fun main() {
    val returnTypeNullable: (String) -> Int? = { null }
    // returnTypeNullable 에 함수 { null }로 초기화
    val mightBeNull: ((String) -> Int)? = null
    // mightBeNull 에 null 로 초기화

    returnTypeNullable("abc") eq null
    // 어떤 값이 들어가도 null 반환

    // mightBeNull("abc") // 변수 자체가 널일 수 있으므로 컴파일 에러
    if (mightBeNull != null) {
        mightBeNull("abc")
    }
    // if 문을 아래와 같이 변환할 수 있다.
    mightBeNull?.let { it("abc") }
}