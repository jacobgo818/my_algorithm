package go.jacob.day0525_26.linkedlist;


import go.jacob.day0520.链表问题.LinkedListOperate;
import go.jacob.day0520.链表问题.ListNode;

import static go.jacob.day0520.链表问题.LinkedListOperate.createLinkedList;

/**
 * Sort a linked list in O(n log n) time using constant space complexity.
 * <p>
 * Example 1:
 * <p>
 * Input: 4->2->1->3
 * Output: 1->2->3->4
 * Example 2:
 * <p>
 * Input: -1->5->3->4->0
 * Output: -1->0->3->4->5
 * <p>
 * 解法：
 * 在链表上采用O(n log n)
 * 很多排序算法都要按index查找元素
 * 只有归并排序满足要求
 */
public class P148_SortList {
    public static ListNode sortList(ListNode head) {
        if (head == null || head.next == null)
            return head;
        ListNode preEnd = head, slow = head, fast = head;
        while (fast != null && fast.next != null) {
            preEnd = slow;
            slow = slow.next;
            fast = fast.next.next;
        }

        preEnd.next = null;//截断两个链表，不能用slow代替preEnd指针，因为slow记录了后半链表的头结点

        ListNode l1 = sortList(head);
        ListNode l2 = sortList(slow);

        return merge(l1, l2);

    }

    private static ListNode merge(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(0);
        ListNode cur = dummy;
        while (l1 != null && l2 != null) {
            if (l1.val <= l2.val) {
                cur.next = l1;
                l1 = l1.next;
                cur = cur.next;
            } else {
                cur.next = l2;
                l2 = l2.next;
                cur = cur.next;
            }

        }

        if (l1 != null)
            cur.next = l1;
        if (l2 != null)
            cur.next = l2;

        return dummy.next;

    }

    public static void main(String[] args) {
        ListNode head = createLinkedList(new int[]{-1, 5, 3, 4, 0}, 5);
        ListNode node = sortList(head);
        LinkedListOperate.printLinkedList(node);
    }

}
