class ListNode(var `val`: Int = 0) {
    var next: ListNode? = null

    override fun toString(): String {
        val result = StringBuilder(`val`.toString())
        var current: ListNode? = next
        while (current != null) {
            result.append("->${current.`val`}")
            current = current.next
        }
        return result.toString()
    }

}

fun String.toListNode(): ListNode? {
    if (this == "null") {
        return null
    }
    val nodes = this.split("->").map { Integer.parseInt(it) }.map { ListNode(it) }
    val head = nodes.first()
    for (i in 0 until nodes.size - 1) {
        nodes[i].next = nodes[i + 1]
    }
    return head
}