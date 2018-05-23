package go.jacob.day0522.linkedlist;


import go.jacob.day0520.链表问题.LinkedListOperate;
import go.jacob.day0520.链表问题.ListNode;

import java.util.Stack;

import static go.jacob.day0520.链表问题.LinkedListOperate.createLinkedList;

/**
 * You are given two non-empty linked lists representing two non-negative integers.
 * The most significant digit comes first and each of their nodes contain a single digit.
 * Add the two numbers and return it as a linked list.
 * <p>
 * You may assume the two numbers do not contain any leading zero, except the number 0 itself.
 * <p>
 * Follow up:
 * What if you cannot modify the input lists? In other words, reversing the lists is not allowed.
 * <p>
 * Example:
 * <p>
 * Input: (7 -> 2 -> 4 -> 3) + (5 -> 6 -> 4)
 * Output: 7 -> 8 -> 0 -> 7
 */
public class P445_AddTwoNumbersII {

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        Stack<Integer> stack1 = new Stack<Integer>();
        Stack<Integer> stack2 = new Stack<Integer>();
        while (l1 != null) {
            stack1.push(l1.val);
            l1 = l1.next;
        }
        while (l2 != null) {
            stack2.push(l2.val);
            l2 = l2.next;
        }

        int carry = 0;
        ListNode node = null;
        while (!stack1.isEmpty() || !stack2.isEmpty()) {
            int x = stack1.isEmpty() ? 0 : stack1.pop();
            int y = stack2.isEmpty() ? 0 : stack2.pop();
            carry = x + y + carry;
            ListNode tmp = new ListNode(carry % 10);
            tmp.next = node;
            node = tmp;
            carry = carry / 10;
        }

        if (carry != 0) {
            ListNode tmp = new ListNode(carry);
            tmp.next = node;
            node = tmp;
        }


        return node;
    }

    public static void main(String[] args) {
        ListNode l1 = createLinkedList(new int[]{7, 2, 4, 3}, 4);
        ListNode l2 = createLinkedList(new int[]{5, 6, 4}, 3);
        ListNode node = addTwoNumbers(l1, l2);
        LinkedListOperate.printLinkedList(node);
    }

}
