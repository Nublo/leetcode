class ListNode(var `val`: Int = 0) {
    var next: ListNode? = null
}

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