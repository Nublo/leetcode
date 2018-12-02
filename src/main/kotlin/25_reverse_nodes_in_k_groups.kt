/**
 * https://leetcode.com/problems/reverse-nodes-in-k-group/
 *
 * Given a linked list, reverse the nodes of a linked list k at a time and return its modified list.
 * k is a positive integer and is less than or equal to the length of the linked list.
 * If the number of nodes is not a multiple of k then left-out nodes in the end should remain as it is.
 *
 * Solution:
 * First code simple rotation list.
 * Than apply this solution
 *
 * O(N)
 * N - length of linkedList
 */

fun reverseKGroup(head: ListNode?, k: Int): ListNode? {
    if (head == null || k <= 1) return head
    var count = 0
    var current = head
    while (current != null) {
        current = current.next
        count++
    }
    if (count < k) {
        return head
    } else {
        current = head
        count = 0
        var prev: ListNode? = null
        while (count < k) {
            val next: ListNode? = current?.next
            current?.next = prev
            prev = current
            current = next
            count++
        }
        if (current != null) {
            head.next = reverseKGroup(current, k) // Tricky but easiest part to rotate remaining part
        }
        return prev
    }
}