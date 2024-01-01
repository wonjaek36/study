package chapter3.NamedAndDefaultArgs

import appendix.atomictest.eq

fun main() {
    """
        |->Last night I saw upon the stair
            |->A little man who wasn't there
            |->He wasn't there again today
            |->Oh, how I wish he'd go away
    """.trimMargin() eq """
        ->Last night I saw upon the stair
        ->A little man who wasn't there
        ->He wasn't there again today
        ->Oh, how I wish he'd go away""".trimIndent()

    """
        |->Last night I saw upon the stair
            |->A little man who wasn't there
            |->He wasn't there again today
            |->Oh, how I wish he'd go away
    """.trimMargin(marginPrefix = "|->") eq """
        Last night I saw upon the stair
        A little man who wasn't there
        He wasn't there again today
        Oh, how I wish he'd go away""".trimIndent()
}