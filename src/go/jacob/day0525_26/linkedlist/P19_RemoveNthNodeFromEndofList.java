package go.jacob.day0525_26.linkedlist;

import go.jacob.day0520.链表问题.ListNode;

/**
 * Given a linked list, remove the n-th node from the end of list and return its head.
 * <p>
 * Example:
 * <p>
 * Given linked list: 1->2->3->4->5, and n = 2.
 * <p>
 * After removing the second node from the end, the linked list becomes 1->2->3->5.
 * Note:
 * <p>
 * Given n will always be valid.
 * <p>
 * Follow up:
 * <p>
 * Could you do this in one pass?
 * <p>
 * 解法：经典的双指针问题，控制好fast和slow指针的间隔即可(遍历一次即可)
 *
 * 有个坑：当题目要求删除某个节点的时候，都必须创建一个虚拟头结点
 */
public class P19_RemoveNthNodeFromEndofList {

    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode fast = head, slow = head;
        for (int i = 0; i < n; i++) {
            if (fast == null)
                return head;
            fast = fast.next;
        }
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode pre = dummy;
        while (fast != null) {
            pre = pre.next;
            fast = fast.next;
            slow = slow.next;
        }
        pre.next = slow.next;

        return dummy.next;
    }
}
