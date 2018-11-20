/**
 * https://leetcode.com/problems/swap-nodes-in-pairs/
 *
 * Given a linked list, swap every two adjacent nodes and return its head.
 * Your algorithm should use only constant extra space.
 * You may not modify the values in the list's nodes, only nodes itself may be changed.
 *
 * Solution:
 * Just code it)
 *
 * O(N)
 * N - length of linkedList
 */

fun swapPairs(head: ListNode?): ListNode? {
    var answer: ListNode? = head
    var first: ListNode? = head
    var second: ListNode? = first?.next
    var prev: ListNode? = null
    while (first != null && second != null) {
        val nextPointer = second.next
        first.next = nextPointer
        second.next = first
        if (prev == null) {
            answer = second
        } else {
            prev.next = second
        }
        prev = first
        first = nextPointer
        second = first?.next
    }
    return answer
}