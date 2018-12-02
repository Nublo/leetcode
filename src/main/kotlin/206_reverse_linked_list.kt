/**
 * https://leetcode.com/problems/reverse-linked-list/
 *
 * Reverse a singly linked list.
 *
 * Solution:
 * Just keep pointer on current and previous position and manipulate them
 *
 * Complexity - O(N)
 * Additional space - O(1)
 */

fun reverseList(head: ListNode?): ListNode? {
    if (head == null) return head
    var prev: ListNode? = null
    var current: ListNode? = head
    while (current != null) {
        val next = current.next
        current.next = prev
        prev = current
        current = next
    }
    return prev
}