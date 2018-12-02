/**
 * https://leetcode.com/problems/rotate-list/
 *
 * Given a linked list, rotate the list to the right by k places, where k is non-negative.
 *
 * Solution:
 * Find position where should we cut list.
 * Cut it here, and update next pointers
 *
 * Complexity - O(N)
 * Additional space - O(1)
 */

fun rotateRight(head: ListNode?, k: Int): ListNode? {
    if (head == null || k <= 0) return head
    val length = head.length()
    val operations = k % length
    if (operations == 0) return head

    var nodeToRotate: ListNode? = head
    var index = 0
    while (index < (length - operations - 1)) {
        nodeToRotate = nodeToRotate?.next
        index++
    }

    val newHead = nodeToRotate?.next
    var current = nodeToRotate
    while(current?.next != null) {
        current = current.next
    }

    current?.next = head
    nodeToRotate?.next = null
    return newHead
}