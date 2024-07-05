package chapter4.MemberReferences

import appendix.atomictest.eq

data class Message(
    val sender: String,
    val text: String,
    val isRead: Boolean
)

fun main() {
    val messages = listOf(
        Message("Kitty", "Hey!", true),
        Message("Kitty", "Where are you?", false))

    val unread = messages.filterNot(Message::isRead) // filter out isRead value is true
    unread.size eq 1
    // unwrap list when list has only one element.
    unread.single().text eq "Where are you?"
}