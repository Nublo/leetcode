/**
 * https://leetcode.com/problems/remove-nth-node-from-end-of-list/solution/
 *
 * Given a linked list, remove the n-th node from the end of list and return its head.
 *
 * Solution:
 * Use 2 pointers divided by N elements, when last pointer will point to the end,
 * it means first pointer is pointing where should we remove item.
 *
 * Complexity - O(N), Additional Space - O(1)
 * N - length of list
 */

fun removeNthFromEnd(head: ListNode, n: Int): ListNode? {
    val mock = ListNode(0)
    mock.next = head
    var first: ListNode? = mock
    var second: ListNode? = mock
    for (i in 0..n) {
        first = first?.next
    }
    while (first != null) {
        first = first.next
        second = second?.next
    }
    second?.next = second?.next?.next
    return mock.next
}