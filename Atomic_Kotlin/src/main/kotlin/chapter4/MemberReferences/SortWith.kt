package chapter4.MemberReferences

import appendix.atomictest.eq

fun main() {
    val messages = listOf(
        Message("Kitty", "Hey!", true),
        Message("Kitty", "Where are you!", false),
        Message("Boss", "Meeting today", false))
    messages.sortedWith(
        compareBy(Message::isRead, Message::sender)
    ) eq listOf(
        // Unread, order sender by ascending
        Message("Boss", "Meeting today", false),
        Message("Kitty", "Where are you!", false),

        // Read, order sender by ascending
        Message("Kitty", "Hey!", true)
    )
}