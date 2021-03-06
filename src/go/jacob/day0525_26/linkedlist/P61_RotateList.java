package go.jacob.day0525_26.linkedlist;


import go.jacob.day0520.链表问题.ListNode;

/**
 * Given a linked list, rotate the list to the right by k places, where k is non-negative.
 * <p>
 * Example 1:
 * <p>
 * Input: 1->2->3->4->5->NULL, k = 2
 * Output: 4->5->1->2->3->NULL
 * Explanation:
 * rotate 1 steps to the right: 5->1->2->3->4->NULL
 * rotate 2 steps to the right: 4->5->1->2->3->NULL
 * Example 2:
 * <p>
 * Input: 0->1->2->NULL, k = 4
 * Output: 2->0->1->NULL
 * Explanation:
 * rotate 1 steps to the right: 2->0->1->NULL
 * rotate 2 steps to the right: 1->2->0->NULL
 * rotate 3 steps to the right: 0->1->2->NULL
 * rotate 4 steps to the right: 2->0->1->NULL
 */
public class P61_RotateList {
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null || head.next == null)
            return head;

        ListNode dummy = new ListNode(0);
        ListNode fast = dummy, slow = dummy;
        dummy.next = head;

        int i;


        for (i = 0; fast.next != null; i++)//fast是最后一个节点，i是节点数
            fast = fast.next;

        for (int j = i - k % i; j > 0; j--)
            slow = slow.next;

        fast.next = dummy.next;
        dummy.next = slow.next;
        slow.next = null;


        return dummy.next;
    }

}
