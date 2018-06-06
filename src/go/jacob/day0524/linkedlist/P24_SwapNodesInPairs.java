package go.jacob.day0524.linkedlist;


import go.jacob.day0520.链表问题.LinkedListOperate;
import go.jacob.day0520.链表问题.ListNode;

import static go.jacob.day0520.链表问题.LinkedListOperate.createLinkedList;

/**
 * Given a linked list, swap every two adjacent nodes and return its head.
 * <p>
 * Example:
 * <p>
 * Given 1->2->3->4, you should return the list as 2->1->4->3.
 * Note:
 * <p>
 * Your algorithm should use only constant extra space.
 * You may not modify the values in the list's nodes, only nodes itself may be changed.
 */
public class P24_SwapNodesInPairs {

    public static ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null)
            return head;

        ListNode dummy = new ListNode(0);
        dummy.next = head;

        ListNode cur = dummy;
        while (cur != null) {
            cur = swap(cur);
        }


        return dummy.next;
    }

    private static ListNode swap(ListNode cur) {
        if (cur.next == null || cur.next.next == null)
            return null;

        ListNode first = cur.next, second = first.next, third = second.next;
        cur.next = second;
        second.next = first;
        first.next = third;
        return first;
    }

    public static void main(String[] args) {

        ListNode head = createLinkedList(new int[]{1, 2, 3, 4, 5, 6,7}, 7);
        ListNode node = swapPairs(head);
        LinkedListOperate.printLinkedList(node);

    }




}
