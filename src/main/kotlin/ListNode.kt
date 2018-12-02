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