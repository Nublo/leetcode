/**
 * https://leetcode.com/problems/remove-duplicates-from-sorted-list-ii/
 *
 * Given a sorted linked list, delete all nodes that have duplicate numbers,
 * leaving only distinct numbers from the original list.
 *
 * Solution:
 * Put everything in hashSet, when meet copy, just keep it
 *
 * Complexity - O(N)
 * Additional space - O(N)
 */

fun deleteDuplicates(head: ListNode?): ListNode? {
    val set: MutableMap<Int, Boolean> = mutableMapOf()
    var current: ListNode? = head
    while (current != null) {
        set[current.`val`] = set.containsKey(current.`val`)
        current = current.next
    }

    var mockHead = ListNode(0)
    mockHead.next = head
    var prev: ListNode? = mockHead
    current = head
    while (current != null) {
        while (current != null && set[current?.`val`] == true) {
            prev?.next = current?.next
            current = current?.next
        }
        prev = current
        current = current?.next
    }

    return mockHead.next
}