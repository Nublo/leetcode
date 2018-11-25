/**
 * https://leetcode.com/problems/add-two-numbers/description/
 *
 * You are given two non-empty linked lists representing two non-negative integers.
 * The digits are stored in reverse order and each of their nodes contain a single digit.
 * Add the two numbers and return it as a linked list.
 * You may assume the two numbers do not contain any leading zero, except the number 0 itself.
 *
 * Solution:
 * O(max(N,M))
 * N,M are lengths of l1,l2
 */
fun addTwoNumbers(l1: ListNode?, l2: ListNode?): ListNode {
    var s1 = l1
    var s2 = l2
    val head = ListNode(0)
    var copy: ListNode? = head
    var carry = 0
    while (s1 != null || s2 != null) {
        val left = s1?.`val` ?: 0
        val right = s2?.`val` ?: 0
        val sum = left + right + carry

        carry = sum / 10
        copy?.next = ListNode(sum % 10)

        copy = copy?.next
        s1 = s1?.next
        s2 = s2?.next
    }
    if (carry != 0) {
        copy?.next = ListNode(carry)
    }
    return head.next!!
}