package chapter4.MemberReferences

import appendix.atomictest.eq

fun ignore(message: VerboseMessage) =
    !message.isImportant() && message.sender in setOf("Boss", "Mom")

fun main() {
    val text = "Let's discuss goals for the next year"
    val msgs = listOf(
        VerboseMessage("Boss", text, false, listOf()),
        VerboseMessage("Boss", text, false, listOf(
            Attachment("image", "cute cats")
        ))
    )
    msgs.filter(::ignore).size eq 1
    msgs.filterNot(::ignore).size eq 1
}