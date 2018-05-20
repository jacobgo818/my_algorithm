package go.jacob.day0520.¡¥±ÌŒ Ã‚;

/**
 * Given a sorted linked list,
 * delete all duplicates such that each element appear only once.
 * <p>
 * Example 1:
 * <p>
 * Input: 1->1->2
 * Output: 1->2
 * Example 2:
 * <p>
 * Input: 1->1->2->3->3
 * Output: 1->2->3
 */
public class P83_RemoveDuplicatesFromSortedList {
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null)
            return head;
        ListNode cur = head, next = head.next;
        while (next != null) {
            while (next != null && cur.val == next.val) {
                next = next.next;
            }
            cur.next = next;
            cur = next;
            if (next != null)
                next = next.next;
        }

        return head;

    }

    static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
}
