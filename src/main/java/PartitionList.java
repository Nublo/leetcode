/**
 * 86 https://leetcode.com/problems/partition-list/
 *
 * Given a linked list and a value x, partition it such that all nodes less than x come before nodes greater than or equal to x.
 * You should preserve the original relative order of the nodes in each of the two partitions.
 *
 * Solution:
 * 1. Find position where to insert in case of finding incorrect value
 * 2. Insert it, if we will find incorrect value
 */
public class PartitionList {
    public ListNode partition(ListNode head, int x) {
        if (head == null) return null;
        ListNode mockHead = new ListNode(0);
        mockHead.next = head;
        ListNode left = head;
        ListNode prev = mockHead;
        ListNode positionToInsert = null;
        Boolean needReplace = false;

        while (left != null) {
            if (left.val >= x) {
                needReplace = true;
                if (positionToInsert == null) {
                    positionToInsert = prev;
                }
            }
            if (left.val < x && needReplace) {
                ListNode toSwap = left;
                prev.next = left.next;
                left = left.next;
                toSwap.next = positionToInsert.next;
                positionToInsert.next = toSwap;
                positionToInsert = positionToInsert.next;
            } else {
                prev = left;
                left = left.next;
            }
        }
        return mockHead.next;
    }
}
// 1->4->3->2->5->2, x = 3
//
// 1->2->2->4->3->5