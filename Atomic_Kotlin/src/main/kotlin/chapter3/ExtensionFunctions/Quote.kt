package chapter3.ExtensionFunctions

import appendix.atomictest.eq
// 패키지가 다르면 아래 임포트를 해야함
// import chapter3.ExtensionFunctions.singleQuote
// import chapter3.ExtensionFunctions.doubleQuote

fun main() {
    "Single".singleQuote() eq "'Single'"
    "Double".doubleQuote() eq "\"Double\""
}