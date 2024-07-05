package chapter4.MemberReferences

import appendix.atomictest.eq

data class VerboseMessage(
    val sender: String,
    val text: String,
    val isRead: Boolean,
    val attachments: List<Attachment>
)

data class Attachment(
    val type: String,
    val name: String
)

fun VerboseMessage.isImportant(): Boolean =
    text.contains("Salary increase") ||
        attachments.any { it.type == "image" && it.name.contains("cat") }

fun main() {
    val messages = listOf(VerboseMessage(
        "Boss", "Let's discuss goals " +
        "for next year", false,
        listOf(
            Attachment("image", "cute cats")
        )))

    messages.any(VerboseMessage::isImportant) eq true
}