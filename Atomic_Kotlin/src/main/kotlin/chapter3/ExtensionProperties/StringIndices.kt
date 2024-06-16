package chapter3.ExtensionProperties
import appendix.atomictest.eq

val String.indices: IntRange get() = 0 until length