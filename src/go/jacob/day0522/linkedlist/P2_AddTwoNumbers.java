package go.jacob.day0522.linkedlist;

import go.jacob.day0520.链表问题.LinkedListOperate;
import go.jacob.day0520.链表问题.ListNode;

import static go.jacob.day0520.链表问题.LinkedListOperate.createLinkedList;

/**
 * You are given two non-empty linked lists representing two non-negative integers.
 * The digits are stored in reverse order and each of their nodes contain a single digit. Add the two numbers and return it as a linked list.
 * <p>
 * You may assume the two numbers do not contain any leading zero, except the number 0 itself.
 * <p>
 * Example
 * <p>
 * Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
 * Output: 7 -> 0 -> 8
 * Explanation: 342 + 465 = 807.
 */
public class P2_AddTwoNumbers {

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int carry = 0;
        ListNode head = new ListNode(0);
        ListNode node = head;

        while (l1 != null && l2 != null) {
            carry = l1.val + l2.val + carry;
            ListNode tmp = new ListNode(carry % 10);
            node.next = tmp;
            node = node.next;
            l1 = l1.next;
            l2 = l2.next;
            carry = carry / 10;
        }

        while (l1 != null) {
            carry = l1.val + carry;
            ListNode tmp = new ListNode(carry % 10);
            node.next = tmp;
            node = node.next;
            l1 = l1.next;
            carry = carry / 10;
        }
        while (l2 != null) {
            carry = l2.val + carry;
            ListNode tmp = new ListNode(carry % 10);
            node.next = tmp;
            node = node.next;
            l2 = l2.next;
            carry = carry / 10;
        }

        if (carry != 0)
            node.next = new ListNode(carry);

        return head.next;
    }

    public static void main(String[] args) {
        ListNode l1 = createLinkedList(new int[]{2, 4, 3}, 3);
        ListNode l2 = createLinkedList(new int[]{5, 6, 4}, 3);
        ListNode node = addTwoNumbers(l1, l2);
        LinkedListOperate.printLinkedList(node);
    }
}
