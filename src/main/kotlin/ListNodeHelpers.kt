fun rotateNodes(head: ListNode?): ListNode? {
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

fun String.toListNode(): ListNode? {
    if (this == "null" || this.isEmpty()) {
        return null
    }
    val nodes = this.split("->").map { Integer.parseInt(it) }.map { ListNode(it) }
    val head = nodes.first()
    for (i in 0 until nodes.size - 1) {
        nodes[i].next = nodes[i + 1]
    }
    return head
}

fun ListNode?.length(): Int =
        when (this) {
            null -> 0
            else -> 1 + this.next.length()
        }

// Didn't find such task yet, let's keep maybe will be useful
fun rotateStartGroup(head: ListNode?, k: Int): ListNode? {
    if (head == null || k <= 1) return head
    var prev: ListNode? = null
    var current: ListNode? = head
    var counter = 0
    while (counter < k) {
        val next = current?.next
        current?.next = prev
        prev = current
        current = next
        counter++
    }
    head.next = current
    return prev
}