package go.jacob.day0524.linkedlist;


import go.jacob.day0520.链表问题.LinkedListOperate;
import go.jacob.day0520.链表问题.ListNode;

import static go.jacob.day0520.链表问题.LinkedListOperate.createLinkedList;

/**
 * Given a linked list, reverse the nodes of a linked list k at a time and return its modified list.
 * <p>
 * k is a positive integer and is less than or equal to the length of the linked list.
 * If the number of nodes is not a multiple of k then left-out nodes in the end should remain as it is.
 * <p>
 * Example:
 * <p>
 * Given this linked list: 1->2->3->4->5
 * <p>
 * For k = 2, you should return: 2->1->4->3->5
 * <p>
 * For k = 3, you should return: 3->2->1->4->5
 * <p>
 * Note:
 * <p>
 * Only constant extra memory is allowed.
 * You may not alter the values in the list's nodes, only nodes itself may be changed.
 */
public class P25_ReverseNodesInKGroup {

    public static ListNode reverseKGroup(ListNode head, int k) {
        if (head == null)
            return head;

        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode cur = dummy;

        while (cur != null) {
            cur = swap(cur, k);
        }

        return dummy.next;
    }

    private static ListNode swap(ListNode cur, int k) {
        ListNode[] nodes = new ListNode[k];
        ListNode node = cur;
        for (int i = 0; i < k; i++) {
            if (node.next == null)
                return null;
            nodes[i] = node.next;
            node = node.next;
        }

        ListNode next = node.next;
        node = cur;

        for (int i = k - 1; i >= 0; i--) {
            node.next = nodes[i];
            node = nodes[i];
        }

        node.next = next;
        return node;
    }

    public static void main(String[] args) {

        ListNode head = createLinkedList(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10}, 10);
        ListNode node = reverseKGroup(head, 4);
        LinkedListOperate.printLinkedList(node);

    }
}
