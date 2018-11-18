import java.util.*

/**
 * https://leetcode.com/problems/merge-k-sorted-lists/
 *
 * Merge k sorted linked lists and return it as one sorted list. Analyze and describe its complexity.
 *
 * Solution:
 * Just put heads of lists in priorityQueue and iterate while queue is not empty
 *
 * O(N*logK)
 * N - Total amount of nods
 * K - amount of lists
 */

fun mergeKLists(lists: Array<ListNode?>): ListNode? {
    val dumbHead = ListNode(0)
    var current: ListNode? = dumbHead
    val priorityQueue: PriorityQueue<ListNode> = PriorityQueue { a, b -> a.`val` - b.`val` }
    priorityQueue.addAll(lists.filter { it != null }.map { it as ListNode })
    while (priorityQueue.isNotEmpty()) {
        val queueHead: ListNode = priorityQueue.poll()
        current?.next = ListNode(queueHead.`val`)
        current = current?.next
        queueHead.next?.let { priorityQueue.add(it) }
    }
    return dumbHead.next
}