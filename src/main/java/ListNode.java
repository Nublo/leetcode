public class ListNode {

    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder(val + "");
        ListNode current = next;
        while (current != null) {
            result.append("->" + current.val);
            current = current.next;
        }
        return result.toString();
    }

}
